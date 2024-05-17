/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class task3_NativeMethods */

#ifndef _Included_task3_NativeMethods
#define _Included_task3_NativeMethods
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     task3_NativeMethods
 * Method:    crashJvm
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_task3_NativeMethods_crashJvm
  (JNIEnv *, jobject);

/*
 * Class:     task3_NativeMethods
 * Method:    allocateMemory
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_task3_NativeMethods_allocateMemory
  (JNIEnv *, jobject);

/*
 * Class:     task3_NativeMethods
 * Method:    callNativeMethods
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_task3_NativeMethods_callNativeMethods
  (JNIEnv *, jobject);

/*
 * Class:     task3_NativeMethods
 * Method:    getStringLength
 * Signature: (Ljava/lang/String;)I
 */
JNIEXPORT jint JNICALL Java_task3_NativeMethods_getStringLength
  (JNIEnv *, jobject, jstring);

/*
 * Class:     task3_NativeMethods
 * Method:    callObjectMethod
 * Signature: (Ltask3/Bean;)V
 */
JNIEXPORT void JNICALL Java_task3_NativeMethods_callObjectMethod
  (JNIEnv *, jobject, jobject);

/*
 * Class:     task3_NativeMethods
 * Method:    bean
 * Signature: (Ltask3/Bean;I)V
 */
JNIEXPORT void JNICALL Java_task3_NativeMethods_bean
  (JNIEnv *, jobject, jobject, jint);

/*
 * Class:     task3_NativeMethods
 * Method:    allocateNativeStruct
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_task3_NativeMethods_allocateNativeStruct
  (JNIEnv *, jobject);

/*
 * Class:     task3_NativeMethods
 * Method:    getStructValue
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_task3_NativeMethods_getStructValue
  (JNIEnv *, jobject, jlong);

/*
 * Class:     task3_NativeMethods
 * Method:    freeNativeStruct
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_task3_NativeMethods_freeNativeStruct
  (JNIEnv *, jobject, jlong);

#ifdef __cplusplus
}
#endif
#endif