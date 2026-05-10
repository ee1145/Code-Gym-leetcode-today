class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        //row and column
        int m = grid.length;
        int n = grid[0].length;

        for (int layer = 0; layer < Math.min(m, n) / 2; layer++) {
            //borader
            int top = layer;
            int right = n - 1 - layer;
            int bottom = m - 1 - layer;
            int left = layer;

            List<Integer> elements = new ArrayList<>();
            //top
            for (int i = left; i <= right; i++) {
                elements.add(grid[top][i]);
            }
            //right
            for (int i = top + 1; i <= bottom; i++) {
                elements.add(grid[i][right]);
            }
            //bottom
            for (int i = right - 1; i >= left; i--) {
                elements.add(grid[bottom][i]);
            }
            //left
            for (int i = bottom - 1; i > top; i--) {
                elements.add(grid[i][left]);
            }

            int idx = 0;
            int size = elements.size();
            int shift = k % size;

            //top
            for (int i = left; i <= right; i++) {
                grid[top][i] = elements.get((idx + shift) % size);
                idx++;
            }
            //right
            for (int i = top + 1; i <= bottom; i++) {
                grid[i][right] = elements.get((idx + shift) % size);
                idx++;
            }
            //bottom
            for (int i = right - 1; i >= left; i--) {
                grid[bottom][i] = elements.get((idx + shift) % size);
                idx++;
            }
            //left
            for (int i = bottom - 1; i > top; i--) {
                grid[i][left] = elements.get((idx + shift) % size);
                idx++;
            }
            
        }
        return grid;
    }
}