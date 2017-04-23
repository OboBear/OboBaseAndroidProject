# -*- coding: UTF-8 -*-
import web
from models.UserModel import *
from utils.jsonUtil.JsonUtil import *
from models.LoginCodeModel import *
from utils.SMSUtil import *

LOGIN_URL = (
    "/login","LoginController",
    "/login/getCode","LoginCodeController",
    "/login/smsLogin","SMSLoginController",
    "/login/autoLogin","AutoLoginController"
)
# curl -d "phoneNumber=15757115391&passWord=123123" "localhost:8080/login"

"""
@apiGroup Login
@api {get} /login Login
@apiName Login
@apiParam {String} PhoneNumber Phone number,it should be a numerical string of length 11 .
@apiParam {String} PassWord Login password,it should be a string of length between 6 and 13.
@apiSuccess {Integer} errorCode Should be 0.
@apiSuccess {String} errorMsg  Should be empty.
@apiSuccess {UserModel} result UserModel contains all user info.
@apiSuccessExample Success-Response
    {
    "errorCode": 0,
    "errorMsg": "",
    "result": {
                "name": null,
                "accessToken": "MweSgaEP7Td2CsfvOZcIY4H6LuIT",
                "userId": 2,
                "registerTime": "2016-05-06 15:24:26",
                "phone": "15757115391",
                "passWord": "123123"
                }
    }
"""
class LoginController:
    def GET(self):
        return "LoginController"
    def POST(self):
        webParams = web.input()
        logI(webParams)
        phoneNumber = webParams.get("phoneNumber")
        passWord = webParams.get("passWord")
        if (phoneNumber == None or passWord == None):
            return backError(error="参数不全")
        userModel = findUserModelByPhone(phoneNumber=phoneNumber)
        if (userModel == None):
            return backError(error="请先注册用户")
        if (userModel.passWord != passWord):
            return backError(error="密码不正确")
        userAccessToken = random_str(28)
        userModel.accessToken = userAccessToken
        updateAccessToken(userAccessToken=userAccessToken,userId= userModel.userId)
        return backSuccess(result=userModel.getDic())

class LoginCodeController:
    def GET(self):
        return ""
    def POST(self):
        postParams = web.input()
        logI(postParams)
        phoneNumber = postParams.get("phoneNumber")
        loginCodeModel = findLoginCodeModelByPhoneNumber(phoneNumber=phoneNumber)
        loginCode = ""
        if (loginCodeModel != None):
            loginCode = loginCodeModel.loginCode
            currentTime = datetime.now()
            timeDistance = (currentTime - loginCodeModel.sendTime).seconds
            if (timeDistance < 60):
                return backError(error="请在60s后重试")
            sendSMSLoginCode(phoneNumber=phoneNumber,smsLoginCode=loginCode)

        else:
            loginCode = random_num(6)
            sendSMSLoginCode(phoneNumber=phoneNumber,smsLoginCode=loginCode)
            insertLoginCodeModel(phoneNumber=phoneNumber,loginCode=loginCode)
        return backSuccess("发送成功")

class SMSLoginController:
    def GET(self):
        return ""
    def POST(self):

        postParams = web.input()
        logI(postParams)
        phoneNumber = postParams.get("phoneNumber")
        loginCode = postParams.get("loginCode")

        if (phoneNumber == None or loginCode == None):
            return backError(error="参数不够")

        loginCodeModel = findLoginCodeModelByPhoneNumber(phoneNumber = phoneNumber)
        if (loginCodeModel == None):
            return backError(error="错误")
        if (loginCodeModel.loginCode == loginCode):
            userModel = findUserModelByPhone(phoneNumber = phoneNumber)
            if (userModel == None):
                accessToken = random_str(16)
                insertUserModel(phoneNumber=phoneNumber,passWord="",accessToken=accessToken)
                userModel = findUserModelByPhone(phoneNumber = phoneNumber)
            return backSuccess(result=userModel.getDic())


        return backError(error="error")

class AutoLoginController:
    def GET(self):
        return "自动登录"
    def POST(self):
        postParams = web.input()
        logI(postParams)
        accessToken= postParams.get("accessToken")
        if (accessToken == None):
            return backError(error= "参数不全")

        userModel = findUserModelByAccessToken(accessToken=accessToken)
        if (userModel == None):
            return backError(error="error")
        return backSuccess(result=userModel.getDic())


# resp = requests.get( "http://sms-api.luosimao.com/v1/status.json" ,
# auth=("api", "7cd4b5d519b3c049c96b70e960051933"),
#     timeout=5 ,
#     verify=False
# )
# print json.loads( resp.content )



