class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        // 总共有 min(m,n)/2 层
        for (int layer = 0; layer < Math.min(m, n) / 2; layer++) {
            // 定义当前层的四个边界
            int top = layer;
            int bottom = m - 1 - layer;
            int left = layer;
            int right = n - 1 - layer;

            // Step 1: 按逆时针顺序提取当前层元素
            List<Integer> elements = new ArrayList<>();

            // 上边：从左到右
            for (int j = left; j <= right; j++) {
                elements.add(grid[top][j]);
            }
            // 右边：从上到下（跳过右上角，已经加过了）
            for (int i = top + 1; i <= bottom; i++) {
                elements.add(grid[i][right]);
            }
            // 下边：从右到左（跳过右下角）
            for (int j = right - 1; j >= left; j--) {
                elements.add(grid[bottom][j]);
            }
            // 左边：从下到上（跳过左下角和左上角）
            for (int i = bottom - 1; i > top; i--) {
                elements.add(grid[i][left]);
            }

            // Step 2: 计算实际移位数（取模防止超出）
            int size = elements.size();
            int shift = k % size;

            // Step 3: 把旋转后的值放回矩阵
            int idx = 0;

            // 上边
            for (int j = left; j <= right; j++) {
                grid[top][j] = elements.get((idx + shift) % size);
                idx++;
            }
            // 右边
            for (int i = top + 1; i <= bottom; i++) {
                grid[i][right] = elements.get((idx + shift) % size);
                idx++;
            }
            // 下边
            for (int j = right - 1; j >= left; j--) {
                grid[bottom][j] = elements.get((idx + shift) % size);
                idx++;
            }
            // 左边
            for (int i = bottom - 1; i > top; i--) {
                grid[i][left] = elements.get((idx + shift) % size);
                idx++;
            }
        }

        return grid;
    }
}
