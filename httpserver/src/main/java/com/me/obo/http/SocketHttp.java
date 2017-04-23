package com.me.obo.http;


import android.util.Log;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by obo on 2017/4/20.
 * Email:obo1993@gmail.com
 * Git:https://github.com/OboBear
 * Blog:http://blog.csdn.net/leilba
 */
public class SocketHttp {

    private static final String TAG = "SocketHttp";

    private SocketHttpListener socketHttpListener;
    public void startServer(SocketHttpListener socketHttpListener) {
        this.socketHttpListener = socketHttpListener;
        try {
            ServerSocket serverSocket = new ServerSocket(10086);
            while (true) {
                final Socket socket = serverSocket.accept();
                new Thread() {
                    @Override
                    public void run() {
                        super.run();
                        try {
                            doConnect(socket);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void doConnect(Socket socket) throws IOException {
//        Log.i(TAG, "doConnect");
        socket.getInputStream();
        InetAddress ss = socket.getInetAddress();
        String add = ss.getHostAddress();
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintStream printStream = new PrintStream(socket.getOutputStream());
        String line = bufferedReader.readLine();
//        Log.i(TAG, "doConnect head line = " + line);
        HttpModel.HttpModelBuilder httpModelBuilder = new HttpModel.HttpModelBuilder();
        httpModelBuilder.setRequestHead(line);

        while (line != null) {
            line = bufferedReader.readLine();

            if (line.length() == 0) {
                break;
            }
            httpModelBuilder.setMessageHead(line);
        }

        int contentLength = httpModelBuilder.getPostContentLength();

        if (contentLength > 0) {
            char[] data = new char[contentLength];
            int flag = bufferedReader.read(data);
//            System.out.println("post flag = " + flag);
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < contentLength && data[i] != '\0'; i++) {
//                System.out.println("post data = " + data[i]);
                stringBuffer.append(data[i]);
            }
            httpModelBuilder.setPostParams(stringBuffer.toString());
        }
        HttpModel httpModel = httpModelBuilder.build();

        Log.i(TAG, httpModel.requestHead.url.resourcePath);


        if (httpModel.requestHead.url.resourcePath != null && httpModel.requestHead.url.resourcePath.length() > 0) {
            if (httpModel.requestHead.url.resourcePath.endsWith("html")) {
                responseWithFilePath(httpModel.requestHead.url.resourcePath, socket.getOutputStream(), "text/html");
            } else if (httpModel.requestHead.url.resourcePath.endsWith("css")) {
                responseWithFilePath(httpModel.requestHead.url.resourcePath, socket.getOutputStream(), "text/css");
            } else if (httpModel.requestHead.url.resourcePath.endsWith("js")) {
                responseWithFilePath(httpModel.requestHead.url.resourcePath, socket.getOutputStream(), "text/js");
            } else if (httpModel.requestHead.url.resourcePath.endsWith("png") ) {
                responseWithFilePath(httpModel.requestHead.url.resourcePath, socket.getOutputStream(), "image/png");
            } else if (httpModel.requestHead.url.resourcePath.endsWith("jpg") ) {
                responseWithFilePath(httpModel.requestHead.url.resourcePath, socket.getOutputStream(), "image/jpg");
            } else if (httpModel.requestHead.url.resourcePath.endsWith("ico") ) {
                responseWithFilePath(httpModel.requestHead.url.resourcePath, socket.getOutputStream(), "image/jpg");
            } else if (httpModel.requestHead.url.resourcePath.endsWith("jpeg") ) {
                responseWithFilePath(httpModel.requestHead.url.resourcePath, socket.getOutputStream(), "image/jpeg");
            } else {
                responseWithFilePath(httpModel.requestHead.url.resourcePath, socket.getOutputStream(), "text/js");
            }
        }

        printStream.close();
        socket.close();
    }

    boolean responseWithFilePath(String filePath, OutputStream outputStream, String contentType) throws IOException {
//        File file = new File("file:///android_asset/" + filePath);
//        if (!file.exists()) {
//            return false;
//        }
//
//        FileInputStream fileInputStream = new FileInputStream(file);

        InputStream fileInputStream = socketHttpListener.getInputString(filePath);
        if (fileInputStream == null) {
            return false;
        }
        PrintStream printStream = new PrintStream(outputStream);
        printStream.println(getResponseSuccessHead());
        printStream.println("Content-Type: " + contentType);
        printStream.println("Content-Length: " + fileInputStream.available());
        printStream.println();
        while (fileInputStream.available() > 0) {
            byte []inputData = new byte[fileInputStream.available()];
            fileInputStream.read(inputData);
            printStream.write(inputData);
        }

        outputStream.flush();
        printStream.close();
        outputStream.close();
        return true;
    }


    void outPutFile(OutputStream outputStream) throws IOException {

        File file = new File("static/Head.jpg");
        String statusLine = "HTTP/1.1 200 OK";
        String responseBody = "<html><body><h1>Content from server success !</h1></body></html>";
//        String responseHeader = "Content-Type: text/html; charset=UTF-8\r\nContent-Length: " + file.length() + "\r\nContent-Disposition: attachment;filename=hello.jpg" ;
        String responseHeader = "application/binary\r\nContent-Length: " + file.length() + "\r\nContent-Disposition: attachment;filename=hello.jpg" ;

        PrintStream writer = new PrintStream(outputStream);
        writer.println("HTTP/1.0 200 OK");// 返回应答消息,并结束应答
//        writer.println("Content-Type:application/binary");
        writer.println("Content-Type:text/html");
        writer.println("Content-Disposition: attachment;filename=hello.jpg");
        writer.println("Content-Length:" + file.length());// 返回内容字节数
        writer.println();// 根据 HTTP 协议, 空行将结束头信息

        FileInputStream fis = new FileInputStream(file);
        byte[] buf = new byte[fis.available()];
        fis.read(buf);
        writer.write(buf);
        writer.close();
        fis.close();

        outputStream.flush();
        outputStream.close();

    }

    void responseHtml(OutputStream outputStream) throws IOException {
        File file = new File("static/upload.html");
        PrintStream printWriter = new PrintStream(outputStream);
        long fileSize = file.length();
        printWriter.println(getResponseSuccessHead());
        printWriter.println("Content-Length: " + fileSize);
        printWriter.println("Content-Type:text/html");
        printWriter.println();

        FileInputStream fis = new FileInputStream(file);
        byte []buf = new byte[fis.available()];
        fis.read(buf);
        printWriter.write(buf);
        printWriter.close();
        outputStream.flush();
    }

    String getResponseSuccessHead() {
        return "HTTP/1.1 200 OK";
    }

}
