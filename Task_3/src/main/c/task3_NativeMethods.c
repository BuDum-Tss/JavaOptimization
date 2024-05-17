#include "task3_NativeMethods.h"
#include <stdlib.h>
#include <string.h>
#include <limits.h>

JNIEXPORT void JNICALL Java_task3_NativeMethods_crashJvm(JNIEnv *env, jobject obj) {
    while(1) {
        int* array = (int*) malloc(LONG_MAX);
        array[100] = 5;
    }
}

JNIEXPORT void JNICALL Java_task3_NativeMethods_allocateMemory(JNIEnv *env, jobject obj) {
    malloc(1024);
}

JNIEXPORT void JNICALL Java_task3_NativeMethods_callNativeMethods(JNIEnv *env, jobject obj) {
    Java_task3_NativeMethods_crashJvm(env, obj);
}

JNIEXPORT jint JNICALL Java_task3_NativeMethods_getStringLength(JNIEnv *env, jobject obj, jstring str) {
    const char *nativeString = (*env)->GetStringUTFChars(env, str, 0);
    int length = strlen(nativeString);
    (*env)->ReleaseStringUTFChars(env, str, nativeString);
    return length;
}

JNIEXPORT void JNICALL Java_task3_NativeMethods_callObjectMethod(JNIEnv *env, jobject obj, jobject bean) {
    jclass cls = (*env)->GetObjectClass(env, bean);
    jmethodID methodId = (*env)->GetMethodID(env, cls, "method", "()V");
    (*env)->CallVoidMethod(env, bean, methodId);
}

JNIEXPORT void JNICALL Java_task3_NativeMethods_bean(JNIEnv *env, jobject obj, jobject bean, jint newValue) {
    jclass cls = (*env)->GetObjectClass(env, bean);
    jfieldID fieldId = (*env)->GetFieldID(env, cls, "intValue", "I");
    (*env)->SetIntField(env, bean, fieldId, newValue);
}
typedef struct _Structure {
  int field;
} Structure;

JNIEXPORT jlong JNICALL Java_task3_NativeMethods_allocateNativeStruct(JNIEnv *env, jobject obj) {
    Structure* structure = (Structure*) malloc(sizeof(Structure));
    structure->field = 500;
    return (jlong) structure;
}

JNIEXPORT jint JNICALL Java_task3_NativeMethods_getStructValue(JNIEnv *env, jobject obj, jlong ptr) {
    Structure* structure = (Structure*) ptr;
    return structure->field;
}

JNIEXPORT void JNICALL Java_task3_NativeMethods_freeNativeStruct(JNIEnv *env, jobject obj, jlong ptr) {
    Structure* structure = (Structure*) ptr;
    free(structure);
}

