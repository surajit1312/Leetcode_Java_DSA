class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int[][] result = new int[][]{};
        int len = original.length;
        if (m * n != len) {
            return result;
        }
        result = new int[m][n];
        for (int i = 0; i < len; i++) {
            int row = i / n;
            int col = i % n;
            result[row][col] = original[i];
        }
        return result;
    }
}