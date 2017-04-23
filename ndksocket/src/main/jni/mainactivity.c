#include <jni.h>
#include <stdio.h>
#include<Android/log.h>
#include "Log.h"
#include "stdio.h"

JNIEXPORT jint JNICALL
Java_com_me_obo_ndksocket_MainActivity_aTest(JNIEnv *env, jobject instance) {
    // TODO
}

JNIEXPORT jstring JNICALL
Java_com_me_obo_ndksocket_MainActivity_assd(JNIEnv *env, jobject instance, jstring hello_) {
    const char *hello = (*env)->GetStringUTFChars(env, hello_, 0);

    printf("print: %s",hello);


    LOGI("Hello %d",1234);


    (*env)->ReleaseStringUTFChars(env, hello_, hello);

    return (*env)->NewStringUTF(env, "Hello word");
}

JNIEXPORT jintArray JNICALL
Java_com_me_obo_ndksocket_MainActivity_sortArray(JNIEnv *env, jobject instance, jintArray a_) {
    jint *a = (*env)->GetIntArrayElements(env, a_, NULL);


    // TODO

    (*env)->ReleaseIntArrayElements(env, a_, a, 0);

    jintArray b ;
}

void main() {
    printf("12334");
}

JNIEXPORT jobject JNICALL
Java_com_me_obo_ndksocket_MainActivity_getUserList(JNIEnv *env, jobject instance) {

    // TODO
    jclass  cls_ArrayList = (*env)->FindClass(env,"java/util/ArrayList");
    jmethodID construct = (*env)->GetMethodID(env,cls_ArrayList,"<init>","()V");
    jobject obj_ArrayList = (*env)->NewObject(env,cls_ArrayList,construct,"");
    jmethodID arrayList_add = (*env)->GetMethodID(env,cls_ArrayList,"add","(Ljava/lang/Object;)Z");
    jclass cls_user = (*env)->FindClass(env,"com/me/obo/ndksocket/User");
    jmethodID construct_user = (*env)->GetMethodID(env, cls_user, "<init>", "()V");
    jobject obj_user = (*env)->NewObject(env,cls_user,construct_user,"");
//    int i;
//    for(i=0;i<10;i++){
//        //new a object
//        obj_user = (*env)->NewObject(env,cls_user,construct_user,"");
//        //get field id
////        jfieldID user_id = (*env)->GetFieldID(env,cls_user,"id","J");
        jfieldID user_name = (*env)->GetFieldID(env,cls_user,"name","Ljava/lang/String;");
////        jfieldID user_isMan = (*env)->GetFieldID(env,cls_user,"isMan","Z");
////        jfieldID user_age = (*env)->GetFieldID(env,cls_user,"age","I");
////        (*env)->SetLongField(env,obj_user,user_id,i);
        (*env)->SetObjectField(env,obj_user,user_name,(*env)->NewStringUTF(env,"LiangYaoTian"));
////        (*env)->SetBooleanField(env,obj_user,user_isMan,1);
////        (*env)->SetIntField(env,obj_user,user_age,21);
        (*env)->CallObjectMethod(env,obj_ArrayList,arrayList_add,obj_user);
//    }
    return obj_ArrayList;



}

JNIEXPORT jobject JNICALL
Java_com_me_obo_ndksocket_MainActivity_getUser(JNIEnv *env, jobject instance) {

    // TODO

    jclass  cls_user = (*env)->FindClass(env, "com/me/obo/ndksocket/User");
    jmethodID initMethod = (*env)->GetMethodID(env, cls_user, "<init>","()V");
    jobject  user = (*env)->NewObject(env, cls_user, initMethod, "");

    jfieldID fieldName = (*env)->GetFieldID(env, cls_user, "name", "Ljava/lang/String;");
    (*env)->SetObjectField(env,user,fieldName,(*env)->NewStringUTF(env,"LiangYaoTian"));
    return user;
}