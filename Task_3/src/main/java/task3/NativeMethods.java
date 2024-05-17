package task3;

public class NativeMethods {
    static {
        System.loadLibrary("nativelib");
    }

    public native void crashJvm();

    public native void allocateMemory();

    public native void callNativeMethods();

    public native int getStringLength(String str);

    public native void callObjectMethod(Bean bean);

    public native void bean(Bean bean, int newValue);

    public native long allocateNativeStruct();

    public native int getStructValue(long ptr);

    public native void freeNativeStruct(long ptr);
}
