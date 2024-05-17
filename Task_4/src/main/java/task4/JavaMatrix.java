package task4;

public class JavaMatrix {
    private int[][] values;

    public JavaMatrix(int x, int y) {
        values = new int[x][y];
    }

    public JavaMatrix(int[][] matrix_values) {
        values = matrix_values;
    }

    public JavaMatrix mult(JavaMatrix javaMatrix) {
        JavaMatrix result = new JavaMatrix(values.length, javaMatrix.values[0].length);
        for (int x = 0; x < values.length; x++) {
            for (int y = 0; y < javaMatrix.values[0].length; y++) {
                int sum = 0;
                for (int i = 0; i < values[0].length; i++) {
                    sum += values[x][i] * javaMatrix.values[i][y];
                }
                result.values[x][y] = sum;
            }
        }
        return result;
    }

    public int[][] getValues() {
        return values;
    }
}