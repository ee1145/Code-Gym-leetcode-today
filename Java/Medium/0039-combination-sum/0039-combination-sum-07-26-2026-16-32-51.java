class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, 0, new ArrayList<>(), result);
        return result;
    }
    
    private void backtrack(int[] candidates, int target, 
                           int start, int sum,
                           List<Integer> current, 
                           List<List<Integer>> result) {
        if (sum == target) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (sum > target) return;  // 剪枝
        
        for (int i = start; i < candidates.length; i++) {
            current.add(candidates[i]);
            backtrack(candidates, target, i, sum + candidates[i], current, result);
            //                             ↑ 传i不是i+1，允许重复使用
            current.remove(current.size() - 1);
        }
    }
}