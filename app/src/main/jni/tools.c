//
// Created by obo on 15/9/4.
//

#include "tools.h"

jstring getJString(JNIEnv * env, char * resultString)
{
    return (*env)->NewStringUTF(env,resultString);
}