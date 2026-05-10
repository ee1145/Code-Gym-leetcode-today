class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        boolean[] zeroRows = new boolean[m];  // 记录哪些行有0
        boolean[] zeroCols = new boolean[n];  // 记录哪些列有0
        
        // 第一步：扫描，记录有0的行和列
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {           // 发现0
                    zeroRows[i] = true;      // 记录这一行
                    zeroCols[j] = true;      // 记录这一列
                }
            }
        }
        
        // 第二步：置零
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (zeroRows[i] || zeroCols[j]) {    // 这行或这列有0
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
