/*
题目：Walls and Gates
思路：多源 BFS，所有门同时出发，第一次到达某个房间时的步数就是最短距离

步骤：
1. 扫描网格，所有门(0)入队
2. BFS：
   - 取出一个格子，看四个方向
   - 出界 / 不是空房间(INF) → 跳过（墙和已填过的都不是 INF）
   - 是空房间 → 距离 = 当前格子的值 + 1，入队

复杂度：时间 O(m×n)，空间 O(m×n)
易错：只填 INF 的格子，已经填过的不能再改（第一次填的就是最短）
*/
class Solution {
    public void wallsAndGates(int[][] rooms) {
        int rows = rooms.length;
        int cols = rooms[0].length;
        int empty = Integer.MAX_VALUE;
        Queue<int[]> queue = new ArrayDeque<>();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (rooms[r][c] == 0) {
                    queue.offer(new int[]{r, c});
                }
            }
        }

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0];
            int c = cell[1];

            for (int[] d : directions) {
                int nr = r + d[0];
                int nc = c + d[1];
                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) {
                    continue;
                }
                if (rooms[nr][nc] != empty) {
                    continue;
                }
                rooms[nr][nc] = rooms[r][c] + 1;
                queue.offer(new int[]{nr, nc});
            }
        }
    }
}