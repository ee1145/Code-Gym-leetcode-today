/*
题目：Rotting Oranges
思路：多源 BFS，所有烂橘子同时出发，BFS 一层 = 一分钟

步骤：
1. 扫描网格：烂橘子(2)全部入队，同时数新鲜橘子(1)的个数 fresh
2. BFS（队列不空 且 还有新鲜橘子）：
   - 锁定这一层大小 size
   - 取出这一层每个烂橘子，看四个方向
     是新鲜的 → 变成 2，fresh--，入队
   - 这一层处理完，minutes++
3. fresh == 0 → 返回 minutes；否则 → -1

复杂度：时间 O(m×n)，空间 O(m×n)
易错：值是 int，比较用 1/2 不是 '1'/'2'
      循环条件加 fresh > 0，否则最后多算一分钟
*/
class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        int fresh = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) {
                    queue.offer(new int[]{r, c});
                } else if (grid[r][c] == 1) {
                    fresh++;
                }
            }
        }

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int minutes = 0;

        while (!queue.isEmpty() && fresh > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                for (int[] d : directions) {
                    int nr = cell[0] + d[0];
                    int nc = cell[1] + d[1];
                    if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) {
                        continue;
                    }
                    if (grid[nr][nc] != 1) {
                        continue;
                    }
                    grid[nr][nc] = 2;
                    fresh--;
                    queue.offer(new int[]{nr, nc});
                }
            }
            minutes++;
        }

        if (fresh == 0) {
            return minutes;
        }
        return -1;
    }
}