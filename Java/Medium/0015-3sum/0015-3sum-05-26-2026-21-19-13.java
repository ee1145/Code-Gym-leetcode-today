class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums); // 第一步：排序
        
        for (int i = 0; i < nums.length - 2; i++) {
            // 剪枝：最小的数都 > 0，不可能凑成 0
            if (nums[i] > 0) break;
            
            // 去重：跳过重复的第一个数
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            int L = i + 1, R = nums.length - 1;
            
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                
                if (sum < 0) {
                    L++; // 太小，左指针右移
                } else if (sum > 0) {
                    R--; // 太大，右指针左移
                } else {
                    // 找到一组！
                    res.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    
                    // 去重：跳过重复的 L 和 R
                    while (L < R && nums[L] == nums[L + 1]) L++;
                    while (L < R && nums[R] == nums[R - 1]) R--;
                    
                    L++;
                    R--;
                }
            }
        }
        
        return res;
    }
}