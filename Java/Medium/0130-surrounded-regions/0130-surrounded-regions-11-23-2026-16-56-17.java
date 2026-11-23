class Solution {
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        // 1. 从四条边的 'O' 出发，把连通的 O 标成 '#'
        for (int r = 0; r < rows; r++) {
            markSafe(board, r, 0);           // 左边
            markSafe(board, r, cols - 1);    // 右边
        }
        for (int c = 0; c < cols; c++) {
            markSafe(board, 0, c);           // 上边
            markSafe(board, rows - 1, c);    // 下边
        }

        // 2. 遍历整个网格，翻转
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X';       // 被围住的
                } else if (board[r][c] == '#') {
                    board[r][c] = 'O';       // 安全的，恢复
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