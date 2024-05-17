package task4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NativeMatrixTest {

    @Test
    void mult() {
        NativeMatrix m1 = new NativeMatrix(new int[][]{{1, 2}, {2, 3}});
        NativeMatrix m2 = new NativeMatrix(new int[][]{{2, 3}, {3, 4}});
        int[][] expected = {{8, 11}, {13, 18}};
        NativeMatrix result = m1.mult(m2);
        Assertions.assertArrayEquals(expected, result.getValues());

        NativeMatrix m12 = new NativeMatrix(new int[][]{{1, 2, 3}, {2, 3, 4}});
        NativeMatrix m22 = new NativeMatrix(new int[][]{{2, 3}, {3, 4}, {4, 5}});
        int[][] expected2 = {{20, 26}, {29, 38}};
        NativeMatrix result2 = m12.mult(m22);
        Assertions.assertArrayEquals(expected2, result2.getValues());

        NativeMatrix m13 = new NativeMatrix(new int[][]{{1, 2, 3}, {2, 3, 4}, {3, 4, 5}});
        NativeMatrix m23 = new NativeMatrix(new int[][]{{2, 3}, {3, 4}, {4, 5}});
        int[][] expected3 = {{20, 26}, {29, 38}, {38, 50}};
        NativeMatrix result3 = m13.mult(m23);
        Assertions.assertArrayEquals(expected3, result3.getValues());
    }
}