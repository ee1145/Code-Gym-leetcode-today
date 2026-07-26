class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);  // 先排序！
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
        if (sum > target) return;
        
        for (int i = start; i < candidates.length; i++) {
            // 同一层跳过重复元素
            if (i > start && candidates[i] == candidates[i-1]) continue;
            
            current.add(candidates[i]);
            backtrack(candidates, target, i+1, sum+candidates[i], current, result);
            //                              ↑ i+1，每个元素只用一次
            current.remove(current.size()-1);
        }
    }
}