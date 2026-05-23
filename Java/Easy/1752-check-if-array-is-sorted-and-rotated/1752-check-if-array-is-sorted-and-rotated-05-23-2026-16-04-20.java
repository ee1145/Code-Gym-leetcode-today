class Solution {
    public boolean check(int[] nums) {
        int count = 0;
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            // 环形比较：当前元素与下一个元素（最后一个元素会和第0个元素比较）
            if (nums[i] > nums[(i + 1) % n]) {
                count++;
            }
            
            // 剪枝优化：一旦发现突降点超过 1 个，立即返回 false
            if (count > 1) {
                return false;
            }
        }
        
        return true;
    }
}
