//
// Created by obo on 15/9/4.
//

#include "tools.h"

char * getJStringBy()
{
    return "hhhhh";
}

jstring getJString(JNIEnv * env, char * resultString)
{
    return (*env)->NewStringUTF(env,resultString);
}