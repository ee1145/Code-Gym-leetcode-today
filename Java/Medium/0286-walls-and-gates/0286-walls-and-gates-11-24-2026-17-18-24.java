/*
题目：Walls and Gates
思路：多源 BFS，所有门同时出发，第一次到达某个房间时的步数就是最短距离

步骤：
1. 扫描网格，所有门(0)入队
2. BFS：
   - 取出一个格子，看四个方向
   - 出界 → 跳过
   - 不是空房间(INF) → 跳过（墙、门、已填过的都不是 INF）
   - 是空房间 → 距离 = 当前格子的值 + 1，入队

复杂度：时间 O(m×n)，空间 O(m×n)
易错：只填 INF 的格子，第一次填的就是最短，不用再改
*/
class Solution {
    public void wallsAndGates(int[][] rooms) {
        // 准备：rows, cols, emtpry INF, 队列
        int rows = rooms.length;
        int cols = rooms[0].length;
        int empty = Integer.MAX_VALUE;
        Queue<int[]> queue = new ArrayDeque<>();

        // 1. 扫描网格，所有门入队
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (rooms[r][c] == 0) {
                    queue.offer(new int[] {r, c});
                }
            }
        }


        // 四个方向
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        // 2. BFS
        while (!queue.isEmpty()) {
            // 取出一个格子
            int[] cell = queue.poll(); 
            int r = cell[0];
            int c = cell[1];

            for (int[] d : directions) {
                // 算邻居坐标
                int nr = r + d[0];
                int nc = c + d[1];

                // 出界 → 跳过
                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) {
                    continue;
                }

                // 不是 INF → 跳过
                if (rooms[nr][nc] != empty) {
                    continue;
                }

                // 填距离，入队
                rooms[nr][nc] = rooms[r][c] + 1;
                queue.offer(new int[] {nr, nc});
            }
        }
    }
}