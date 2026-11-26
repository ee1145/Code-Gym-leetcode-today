class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1') {
                    count++;
                    sink(grid, r, c);
                }
            }
        }
        return count;
    }

    // 把 (r, c) 所在的整座岛淹掉
    private void sink(char[][] grid, int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) {
            return;   // 出界
        }
        if (grid[r][c] != '1') {
            return;   // 是水或已经淹过
        }

        grid[r][c] = '0';   // 淹掉，标记已访问

        sink(grid, r + 1, c);   // 下
        sink(grid, r - 1, c);   // 上
        sink(grid, r, c + 1);   // 右
        sink(grid, r, c - 1);   // 左
    }
}