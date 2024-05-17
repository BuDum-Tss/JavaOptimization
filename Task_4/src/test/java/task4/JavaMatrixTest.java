package task4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class JavaMatrixTest {

    @Test
    void mult() {
        JavaMatrix m1 = new JavaMatrix(new int[][]{{1, 2}, {2, 3}});
        JavaMatrix m2 = new JavaMatrix(new int[][]{{2, 3}, {3, 4}});
        int[][] expected = {{8, 11}, {13, 18}};
        JavaMatrix result = m1.mult(m2);
        Assertions.assertArrayEquals(expected, result.getValues());

        JavaMatrix m12 = new JavaMatrix(new int[][]{{1, 2, 3}, {2, 3, 4}});
        JavaMatrix m22 = new JavaMatrix(new int[][]{{2, 3}, {3, 4}, {4, 5}});
        int[][] expected2 = {{20, 26}, {29, 38}};
        JavaMatrix result2 = m12.mult(m22);
        Assertions.assertArrayEquals(expected2, result2.getValues());

        JavaMatrix m13 = new JavaMatrix(new int[][]{{1, 2, 3}, {2, 3, 4}, {3, 4, 5}});
        JavaMatrix m23 = new JavaMatrix(new int[][]{{2, 3}, {3, 4}, {4, 5}});
        int[][] expected3 = {{20, 26}, {29, 38}, {38, 50}};
        JavaMatrix result3 = m13.mult(m23);
        Assertions.assertArrayEquals(expected3, result3.getValues());
    }
}