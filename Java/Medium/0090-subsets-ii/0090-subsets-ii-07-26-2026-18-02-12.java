class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);  // 先排序！
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }
    
    private void backtrack(int[] nums, int start,
                           List<Integer> current,
                           List<List<Integer>> result) {
        result.add(new ArrayList<>(current));  // 每次都收集
        
        for (int i = start; i < nums.length; i++) {
            // 同层跳过重复
            if (i > start && nums[i] == nums[i-1]) continue;
            
            current.add(nums[i]);
            backtrack(nums, i+1, current, result);
            current.remove(current.size()-1);
        }
    }
}