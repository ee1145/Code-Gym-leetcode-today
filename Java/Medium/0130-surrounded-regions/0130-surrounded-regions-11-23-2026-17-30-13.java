/*
题目：Surrounded Regions
思路：反过来想 —— 和边界连通的 'O' 不会被围住

步骤：
1. 遍历四条边（左右两列、上下两行）
   从边界的 'O' 出发 DFS，把连通的 'O' 标成 '#'（安全）
2. 遍历整个网格：
   'O' → 'X'   没被救到，被围住了
   '#' → 'O'   安全的，恢复

DFS markSafe(r, c)：
   出界 → return
   不是 'O' → return
   标记 '#'，再往四个方向递归

复杂度：时间 O(m×n)，空间 O(m×n)（递归栈）
易错：字母 'O' 不是数字 '0'；翻转用 if / else if
*/
class Solution {
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        for (int r = 0; r < rows; r++) {
            markSafe(board, r, 0);
            markSafe(board, r, cols - 1);
        }

        for (int c = 0; c < cols; c++) {
            markSafe(board, 0, c);
            markSafe(board, rows - 1, c);
        }
        
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                } else if (board[r][c] == '#') {
                    board[r][c] = 'O';
                }
            }
        }

    }

    private void markSafe(char[][] board, int r, int c) {
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length) {
            return;
        }

        if (board[r][c] != 'O') {
            return;
        }

        board[r][c] = '#';

        markSafe(board, r + 1, c);
        markSafe(board, r - 1, c);
        markSafe(board, r, c + 1);
        markSafe(board, r, c - 1);
    }
}