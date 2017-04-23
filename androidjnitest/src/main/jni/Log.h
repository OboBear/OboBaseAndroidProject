//
// Created by 林露兵 on 16/8/14.
//

#ifndef OBOBASEANDROIDPROJECT_LOG_H
#define OBOBASEANDROIDPROJECT_LOG_H

#include <android/log.h>
#include <jni.h>

#define LOGI(tag,msg) __android_log_print(ANDROID_LOG_INFO,tag, msg)
#define LOGD(tag,msg) __android_log_print(ANDROID_LOG_DEBUG,tag, msg)
#define LOGE(tag,msg) __android_log_print(ANDROID_LOG_ERROR,tag, msg)

#endif //OBOBASEANDROIDPROJECT_LOG_H
