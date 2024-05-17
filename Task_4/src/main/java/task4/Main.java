package task4;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        testJava();
        testNative();
        test(128);
        test(1024);
    }
    static void test(int size){
        System.out.println("\nTest "+size+"x"+size);
        int[][] m1 = generateRandomMatrix(size, size);
        int[][] m2 = generateRandomMatrix(size, size);
        long startTime;
        long endTime;
        JavaMatrix jm = new JavaMatrix(m1);
        JavaMatrix jm2 = new JavaMatrix(m2);
        startTime = System.nanoTime();
        JavaMatrix rjm = jm.mult(jm2);
        endTime = System.nanoTime();
        System.out.println("JavaMatrix\nTime: " + (endTime - startTime) + " ns\n");

        NativeMatrix nm = new NativeMatrix(m1);
        NativeMatrix nm2 = new NativeMatrix(m2);
        startTime = System.nanoTime();
        NativeMatrix rnm = nm.mult(nm2);
        endTime = System.nanoTime();
        System.out.println("NativeMatrix\nTime: " + (endTime - startTime) + " ns\n");
    }
    public static int[][] generateRandomMatrix(int x, int y) {
        int[][] matrix = new int[x][y];
        Random rand = new Random();
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                matrix[i][j] = rand.nextInt(10);
            }
        }
        return matrix;
    }

    static void testJava(){
        JavaMatrix m1 = new JavaMatrix(new int[][]{{1, 2}, {2, 3}});
        JavaMatrix m2 = new JavaMatrix(new int[][]{{2, 3}, {3, 4}});
        int[][] expected = {{8, 11}, {13, 18}};
        JavaMatrix result = m1.mult(m2);
        printAssertion(Arrays.deepEquals(expected, result.getValues()));
        JavaMatrix m12 = new JavaMatrix(new int[][]{{1, 2, 3}, {2, 3, 4}});
        JavaMatrix m22 = new JavaMatrix(new int[][]{{2, 3}, {3, 4}, {4, 5}});
        int[][] expected2 = {{20, 26}, {29, 38}};
        JavaMatrix result2 = m12.mult(m22);
        printAssertion(Arrays.deepEquals(expected2, result2.getValues()));
        JavaMatrix m13 = new JavaMatrix(new int[][]{{1, 2, 3}, {2, 3, 4}, {3, 4, 5}});
        JavaMatrix m23 = new JavaMatrix(new int[][]{{2, 3}, {3, 4}, {4, 5}});
        int[][] expected3 = {{20, 26}, {29, 38}, {38, 50}};
        JavaMatrix result3 = m13.mult(m23);
        printAssertion(Arrays.deepEquals(expected3, result3.getValues()));
    }
    static void testNative() {
        NativeMatrix m1 = new NativeMatrix(new int[][]{{1, 2}, {2, 3}});
        NativeMatrix m2 = new NativeMatrix(new int[][]{{2, 3}, {3, 4}});
        int[][] expected = {{8, 11}, {13, 18}};
        NativeMatrix result = m1.mult(m2);
        printAssertion(Arrays.deepEquals(expected, result.getValues()));
        NativeMatrix m12 = new NativeMatrix(new int[][]{{1, 2, 3}, {2, 3, 4}});
        NativeMatrix m22 = new NativeMatrix(new int[][]{{2, 3}, {3, 4}, {4, 5}});
        int[][] expected2 = {{20, 26}, {29, 38}};
        NativeMatrix result2 = m12.mult(m22);
        printAssertion(Arrays.deepEquals(expected2, result2.getValues()));
        NativeMatrix m13 = new NativeMatrix(new int[][]{{1, 2, 3}, {2, 3, 4}, {3, 4, 5}});
        NativeMatrix m23 = new NativeMatrix(new int[][]{{2, 3}, {3, 4}, {4, 5}});
        int[][] expected3 = {{20, 26}, {29, 38}, {38, 50}};
        NativeMatrix result3 = m13.mult(m23);
        printAssertion(Arrays.deepEquals(expected3, result3.getValues()));

    }
    static void printAssertion(boolean result){
        if (result) {
            System.out.println("The matrix are equal");
        }
        else {
            System.out.println("The matrix are not equal");
        }
    }
}
