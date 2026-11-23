/*
two steps, one helper

1.checking the boards, mark 'O' as '#'

2.cells by cells check each 

helper 
DFS markSafe(board, r, c):
1.out of bound - return
2.not 'O' - return
update as '#' then four directions
*/
class Solution {
    private int rows;
    private int cols;

    public void solve(char[][] board) {

        rows = board.length;
        cols = board[0].length;

        for (int r = 0; r < rows; r++) {
            markSafe(board, r, 0);
            markSafe(board, r, cols - 1);
        }

        for (int c = 0; c < cols; c++) {
            markSafe(board, 0, c);
            markSafe(board, rows - 1, c);
        }

        for (int r = 0 ; r < rows; r++) {
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
        if (r < 0 || r >= rows || c < 0 || c >= cols) {
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