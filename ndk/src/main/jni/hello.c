//
// Created by handsome on 2016/9/19.
//
#include <stdio.h>
#include <stdlib.h>
#include <jni.h>

//env:结构体二级指针，该结构体中封装了大量的函数指针，可以帮助程序员实现某些常用功能
//thiz:本地方法调用者的对象(MainActivity的对象)
jstring Java_org_jeff_ndk_MainActivity_helloWord(JNIEnv* env, jobject thiz){

    char* cstr = "hello Word";
	//把C字符串转换成java字符串
	//jstring     (*NewStringUTF)(JNIEnv*, const char*);
	jstring jstr = (*env)->NewStringUTF(env, cstr);
	return jstr;
}

