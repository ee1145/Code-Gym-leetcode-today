class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        List<Integer> result = new ArrayList<>();

        int top = 0, bottom = m - 1;
        int left = 0, right = n - 1;

        while (top <= bottom && left <= right) {  // ← 层层往里，直到边界交叉
            // 上边
            for (int i = left; i <= right; i++)
                result.add(matrix[top][i]);
            // 右边
            for (int i = top + 1; i <= bottom; i++)
                result.add(matrix[i][right]);
            // 下边（防止重复：top < bottom）
            if (top < bottom)
                for (int i = right - 1; i >= left; i--)
                    result.add(matrix[bottom][i]);
            // 左边（防止重复：left < right）
            if (left < right)
                for (int i = bottom - 1; i > top; i--)
                    result.add(matrix[i][left]);

            // 往里缩一层
            top++; bottom--;
            left++; right--;
        }
        return result;
    }
}
