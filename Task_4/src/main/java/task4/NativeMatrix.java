package task4;

public class NativeMatrix {
    static {
        System.loadLibrary("matrixlib");
    }

    private long pointer;

    public NativeMatrix(int x, int y) {
        pointer = allocateNativeMatrix(x, y);
    }

    public NativeMatrix(int[][] matrixValues) {
        pointer = overrideNativeMatrix(matrixValues);

    }

    private NativeMatrix(long matrixPointer) {
        pointer = matrixPointer;
    }

    public NativeMatrix mult(NativeMatrix nativeMatrix) {
        return new NativeMatrix(mult(pointer, nativeMatrix.pointer));
    }

    public int[][] getValues() {
        return values(pointer);
    }

    private native long allocateNativeMatrix(int x, int y);

    private native long overrideNativeMatrix(int[][] matrix_values);

    private native void freeNativeMatrix(long pointer);

    private native long mult(long firstPointer, long secondPointer);

    private native int[][] values(long pointer);
}
