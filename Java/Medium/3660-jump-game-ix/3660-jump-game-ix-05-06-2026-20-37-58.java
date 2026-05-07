class Solution {
    public int[] maxValue(int[] nums) {
        int n = nums.length;

        // 第一步：计算前缀最大值
        int[] preMax = new int[n];
        preMax[0] = nums[0];
        for (int i = 1; i < n; i++) {
            preMax[i] = Math.max(preMax[i - 1], nums[i]);
        }

        // 第二步：从右往左，维护后缀最小值，计算答案
        int[] ans = new int[n];
        int sufMin = Integer.MAX_VALUE;

        for (int i = n - 1; i >= 0; i--) {
            if (i + 1 < n && preMax[i] > sufMin) {
                // 左边大值 > 右边小值，可以连通右边
                ans[i] = ans[i + 1];
            } else {
                // 无法连通右边，只能取当前前缀最大值
                ans[i] = preMax[i];
            }
            // 更新后缀最小值
            sufMin = Math.min(sufMin, nums[i]);
        }

        return ans;
    }
}
