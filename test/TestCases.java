import functions_assignment.MatrixZeroes;
import org.junit.Assert;
import org.junit.Test;

public class TestCases {
    @Test
    public void test1() {
        int[][] inputMatrix = {{1, 1, 1}, {0, 3, 3}};
        int[][] expectedMatrix = {{0, 1, 1}, {0, 0, 0}};
        int actualMatrix[][] = MatrixZeroes.setMatrixtToZeroes(inputMatrix);
        Assert.assertArrayEquals(expectedMatrix, actualMatrix);
    }
    @Test
    public void test2() {
        int[][] inputMatrix = {{0, 1, 1}, {0, 3, 3},{1, 1, 1}};
        int[][] expectedMatrix = {{0, 0, 0}, {0, 0, 0},{0, 1, 1}};
        int actualMatrix[][] = MatrixZeroes.setMatrixtToZeroes(inputMatrix);
        Assert.assertArrayEquals(expectedMatrix, actualMatrix);
    }
    @Test
    public void test3() {
        int[][] inputMatrix = {{0, 0, 1, 1}, {0, 3, 3, 10},{1, 1, 1, 1}};
        int[][] expectedMatrix = {{0, 0, 0, 0}, {0, 0, 0, 0},{0, 0, 1, 1}};
        int actualMatrix[][] = MatrixZeroes.setMatrixtToZeroes(inputMatrix);
        Assert.assertArrayEquals(expectedMatrix, actualMatrix);
    }
    @Test
    public void test4() {
        int[][] inputMatrix = {{1, 2, 3, 0}, {1, 2, 3, 4},{0, 2, 2, 2}};
        int[][] expectedMatrix = {{0, 0, 0, 0}, {0, 2, 3, 0},{0, 0, 0, 0}};
        int actualMatrix[][] = MatrixZeroes.setMatrixtToZeroes(inputMatrix);
        Assert.assertArrayEquals(expectedMatrix, actualMatrix);
    }
}
