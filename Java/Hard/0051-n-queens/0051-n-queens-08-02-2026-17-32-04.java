class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row : board) Arrays.fill(row, '.');
        
        Set<Integer> cols = new HashSet<>();
        Set<Integer> diag1 = new HashSet<>();  // row-col
        Set<Integer> diag2 = new HashSet<>();  // row+col
        
        backtrack(board, 0, n, cols, diag1, diag2, result);
        return result;
    }
    
    private void backtrack(char[][] board, int row, int n,
                           Set<Integer> cols,
                           Set<Integer> diag1, Set<Integer> diag2,
                           List<List<String>> result) {
        // 收集结果：n行都放完了
        if (row == n) {
            List<String> solution = new ArrayList<>();
            for (char[] r : board) {
                solution.add(new String(r));
            }
            result.add(solution);
            return;
        }
        
        for (int col = 0; col < n; col++) {
            // 检查冲突
            if (cols.contains(col)) continue;
            if (diag1.contains(row - col)) continue;
            if (diag2.contains(row + col)) continue;
            
            // 放皇后
            board[row][col] = 'Q';
            cols.add(col);
            diag1.add(row - col);
            diag2.add(row + col);
            
            // 递归下一行
            backtrack(board, row+1, n, cols, diag1, diag2, result);
            
            // 撤销
            board[row][col] = '.';
            cols.remove(col);
            diag1.remove(row - col);
            diag2.remove(row + col);
        }
    }
}