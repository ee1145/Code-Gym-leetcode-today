class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(n, 0, 0, "", result);
        return result;
    }
    
    private void backtrack(int n, int open, int close,
                           String current, List<String> result) {
        // 收集结果：长度达到2n
        if (current.length() == 2 * n) {
            result.add(current);
            return;
        }
        
        // 加左括号
        if (open < n) {
            backtrack(n, open + 1, close, current + "(", result);
        }
        
        // 加右括号
        if (close < open) {
            backtrack(n, open, close + 1, current + ")", result);
        }
    }
}