class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }
    
    private void backtrack(int[] nums, int start, 
                           List<Integer> current, 
                           List<List<Integer>> result) {
        // 每次进入都加入结果（包括空集）
        result.add(new ArrayList<>(current));
        
        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);           // 选择
            backtrack(nums, i+1, current, result);  // 递归
            current.remove(current.size()-1);       // 撤销
        }
    }
}