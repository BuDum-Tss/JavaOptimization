#include "task4_NativeMatrix.h"
#include <stdlib.h>
#include <string.h>

typedef struct {
    int **values;
    int rows;
    int cols;
} Matrix;

JNIEXPORT jlong JNICALL Java_task4_NativeMatrix_allocateNativeMatrix(JNIEnv *env, jobject obj, jint rows, jint cols) {
    Matrix *matrix = (Matrix *)malloc(sizeof(Matrix));
    if (!matrix) return 0;

    matrix->rows = rows;
    matrix->cols = cols;
    matrix->values = (int **)malloc(rows * sizeof(int *));
    if (!matrix->values) {
        free(matrix);
        return 0;
    }

    for (int i = 0; i < rows; i++) {
        matrix->values[i] = (int *)malloc(cols * sizeof(int));
        if (!matrix->values[i]) {
            for (int j = 0; j < i; j++) {
                free(matrix->values[j]);
            }
            free(matrix->values);
            free(matrix);
            return 0;
        }
        memset(matrix->values[i], 0, cols * sizeof(int));
    }
    return (jlong)matrix;
}

JNIEXPORT jlong JNICALL Java_task4_NativeMatrix_overrideNativeMatrix(JNIEnv *env, jobject obj, jobjectArray values) {
    jsize rows = (*env)->GetArrayLength(env, values);
    jobjectArray firstRow = (jobjectArray)(*env)->GetObjectArrayElement(env, values, 0);
    jsize cols = (*env)->GetArrayLength(env, firstRow);

    Matrix *matrix = (Matrix *)malloc(sizeof(Matrix));
    if (!matrix) return 0;

    matrix->rows = rows;
    matrix->cols = cols;
    matrix->values = (int **)malloc(rows * sizeof(int *));
    if (!matrix->values) {
        free(matrix);
        return 0;
    }

    for (int i = 0; i < rows; i++) {
        jobjectArray row = (jobjectArray)(*env)->GetObjectArrayElement(env, values, i);
        matrix->values[i] = (int *)malloc(cols * sizeof(int));
        if (!matrix->values[i]) {
            for (int j = 0; j < i; j++) {
                free(matrix->values[j]);
            }
            free(matrix->values);
            free(matrix);
            return 0;
        }
        jintArray intArray = (jintArray)row;
        jint *rowElements = (*env)->GetIntArrayElements(env, intArray, 0);
        memcpy(matrix->values[i], rowElements, cols * sizeof(int));
        (*env)->ReleaseIntArrayElements(env, intArray, rowElements, 0);
    }
    return (jlong)matrix;
}

JNIEXPORT void JNICALL Java_task4_NativeMatrix_freeNativeMatrix(JNIEnv *env, jobject obj, jlong ptr) {
    Matrix *matrix = (Matrix *)ptr;
    if (!matrix) return;
    for (int i = 0; i < matrix->rows; i++) {
        free(matrix->values[i]);
    }
    free(matrix->values);
    free(matrix);
}

JNIEXPORT jlong JNICALL Java_task4_NativeMatrix_mult(JNIEnv *env, jobject obj, jlong fst_ptr, jlong snd_ptr) {
    Matrix *matrix1 = (Matrix *)fst_ptr;
    Matrix *matrix2 = (Matrix *)snd_ptr;

    if (matrix1->cols != matrix2->rows) {
        return 0;
    }

    Matrix *result = (Matrix *)malloc(sizeof(Matrix));
    if (!result) return 0;

    result->rows = matrix1->rows;
    result->cols = matrix2->cols;
    result->values = (int **)malloc(result->rows * sizeof(int *));
    if (!result->values) {
        free(result);
        return 0;
    }

    for (int i = 0; i < result->rows; i++) {
        result->values[i] = (int *)malloc(result->cols * sizeof(int));
        if (!result->values[i]) {
            for (int j = 0; j < i; j++) {
                free(result->values[j]);
            }
            free(result->values);
            free(result);
            return 0;
        }
        for (int j = 0; j < result->cols; j++) {
            result->values[i][j] = 0;
            for (int k = 0; k < matrix1->cols; k++) {
                result->values[i][j] += matrix1->values[i][k] * matrix2->values[k][j];
            }
        }
    }
    return (jlong)result;
}

JNIEXPORT jobjectArray JNICALL Java_task4_NativeMatrix_values(JNIEnv *env, jobject obj, jlong ptr) {
    Matrix *matrix = (Matrix *)ptr;
    if (!matrix) return NULL;

    jobjectArray result = (*env)->NewObjectArray(env, matrix->rows, (*env)->FindClass(env, "[I"), NULL);
    for (int i = 0; i < matrix->rows; i++) {
        jintArray row = (*env)->NewIntArray(env, matrix->cols);
        (*env)->SetIntArrayRegion(env, row, 0, matrix->cols, matrix->values[i]);
        (*env)->SetObjectArrayElement(env, result, i, row);
        (*env)->DeleteLocalRef(env, row);
    }
    return result;
}
