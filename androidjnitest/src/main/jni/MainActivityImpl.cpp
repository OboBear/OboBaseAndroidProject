//
// Created by 林露兵 on 16/5/5.
//

#include "com_me_obo_androidjnitest_MainActivity.h"

JNIEXPORT jint JNICALL Java_com_me_obo_androidjnitest_MainActivity_getInt
        (JNIEnv *env, jobject obj) {
    return 2;
}
