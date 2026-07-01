class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        int[][] dist = new int[n][n];
        for (int[] row : dist) Arrays.fill(row, -1);
        
        // 第一步：多源BFS，计算每个格子到最近小偷的距离
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    dist[i][j] = 0;
                    queue.offer(new int[]{i, j});
                }
            }
        }
        
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] d : dirs) {
                int nr = cur[0] + d[0];
                int nc = cur[1] + d[1];
                if (nr >= 0 && nr < n && nc >= 0 && nc < n && dist[nr][nc] == -1) {
                    dist[nr][nc] = dist[cur[0]][cur[1]] + 1;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
        
        // 第二步：二分答案
        int left = 0, right = n;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (canReach(dist, n, mid, dirs)) {
                left = mid;   // 能到达，试试更大的安全系数
            } else {
                right = mid - 1;  // 不能到达，安全系数太高
            }
        }
        
        return left;
    }
    
    // 第三步：BFS验证，给定安全系数mid，能否从(0,0)到(n-1,n-1)
    private boolean canReach(int[][] dist, int n, int mid, int[][] dirs) {
        if (dist[0][0] < mid || dist[n-1][n-1] < mid) return false;
        
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] == n-1 && cur[1] == n-1) return true;
            
            for (int[] d : dirs) {
                int nr = cur[0] + d[0];
                int nc = cur[1] + d[1];
                if (nr >= 0 && nr < n && nc >= 0 && nc < n 
                    && !visited[nr][nc] && dist[nr][nc] >= mid) {
                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
        
        return false;
    }
}