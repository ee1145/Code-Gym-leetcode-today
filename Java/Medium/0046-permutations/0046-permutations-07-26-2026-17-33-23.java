class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums, used, new ArrayList<>(), result);
        return result;
    }
    
    private void backtrack(int[] nums, boolean[] used,
                           List<Integer> current,
                           List<List<Integer>> result) {
        // 收集结果：路径长度等于数组长度
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        // 每次从头开始遍历
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;  // 跳过已用的
            
            used[i] = true;
            current.add(nums[i]);
            backtrack(nums, used, current, result);
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
}