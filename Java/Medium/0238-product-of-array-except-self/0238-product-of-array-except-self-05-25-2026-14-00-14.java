class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        // ✅ 第一步：从左往右，计算每个位置的"左边积"，存入 answer
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        int right = 1;
        // ✅ 第二步：从右往左，用变量 right 滚动累乘"右边积"
        for (int i = n - 1; i >= 0; i--) {
            answer[i] *= right;
            right *= nums[i];
        }
        return answer;
    }
}