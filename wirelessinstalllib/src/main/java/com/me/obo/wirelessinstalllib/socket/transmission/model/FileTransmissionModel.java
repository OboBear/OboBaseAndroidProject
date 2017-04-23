package com.me.obo.wirelessinstalllib.socket.transmission.model;

/**
 * Created by obo on 2017/3/19.
 * Email:obo.lin@dingtone.me
 */

public class FileTransmissionModel {

    private String fileName;
    private Long fileSize;
    private String hostIp;
    private int port;
    private String sha;
    private Long currentSize = 0L;
    private String destinationFilePath = "";

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public String getHostIp() {
        return hostIp;
    }

    public void setHostIp(String hostIp) {
        this.hostIp = hostIp;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getSha() {
        return sha;
    }

    public void setSha(String sha) {
        this.sha = sha;
    }

    public Long getCurrentSize() {
        return currentSize;
    }

    public void setCurrentSize(Long currentSize) {
        this.currentSize = currentSize;
    }

    public String getDestinationFilePath() {
        return destinationFilePath;
    }

    public void setDestinationFilePath(String destinationFilePath) {
        this.destinationFilePath = destinationFilePath;
    }

    public String  getFileFullPath() {
        return getDestinationFilePath() + "/" + getFileName();
    }
}
