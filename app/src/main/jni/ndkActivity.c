#include "com_obo_mydemos_ndk_NdkActivity.h"
#include "tools.h"

JNIEXPORT jint JNICALL Java_com_obo_mydemos_ndk_NdkActivity_getNDKInt
        (JNIEnv * env, jobject obj)
{
    int b = 2;
    return b;
}


JNIEXPORT jstring JNICALL Java_com_obo_mydemos_ndk_NdkActivity_getNDKString
        (JNIEnv * env, jobject obj)
{
//    return (*env)->NewStringUTF(env,getJStringBy());
    return getJString(env,"ni hao ya ");
}
