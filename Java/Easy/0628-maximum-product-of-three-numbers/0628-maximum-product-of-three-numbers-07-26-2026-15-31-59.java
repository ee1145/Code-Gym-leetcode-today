class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        
        // 情况1：最大三个数
        int case1 = nums[n-1] * nums[n-2] * nums[n-3];
        
        // 情况2：最小两个数 × 最大一个数
        int case2 = nums[0] * nums[1] * nums[n-1];
        
        return Math.max(case1, case2);
    }
}