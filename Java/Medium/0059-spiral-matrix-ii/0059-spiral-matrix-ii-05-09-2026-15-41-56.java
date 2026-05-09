class Solution {
    public int[][] generateMatrix(int n) {
        int num = 1;          // 从1开始填
        int top = 0, bottom = n - 1;
        int left = 0, right = n - 1;

        int[][] matrix = new int[n][n];

        while (top <= bottom && left <= right) {
            // 上边：matrix[top][i] = num++
            for (int i = left; i <= right; i++) {
                matrix[top][i] = num++;
            }
            // 右边：matrix[i][right] = num++
            for (int i = top + 1; i <= bottom; i++) {
                matrix[i][right] = num++;
            }
            // 下边：matrix[bottom][i] = num++
            for (int i = right - 1; i >= left; i--) {
                matrix[bottom][i] = num++;
            }
            // 左边：matrix[i][left] = num++
            for (int i = bottom - 1; i > top; i--) {
                matrix[i][left] = num++;
            }
            
            top++; bottom--;
            left++; right--;
        }
        return matrix;
    }
}