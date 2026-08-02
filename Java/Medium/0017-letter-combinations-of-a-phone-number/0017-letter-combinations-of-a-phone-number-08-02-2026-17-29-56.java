class Solution {
    String[] phone = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.isEmpty()) return result;
        
        backtrack(digits, 0, new StringBuilder(), result);
        return result;
    }
    
    private void backtrack(String digits, int index,
                           StringBuilder current,
                           List<String> result) {
        // 收集结果：处理完所有数字
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }
        
        // 当前数字对应的字母
        String letters = phone[digits.charAt(index) - '2'];
        
        for (char c : letters.toCharArray()) {
            current.append(c);                        // 选择
            backtrack(digits, index+1, current, result); // 递归
            current.deleteCharAt(current.length()-1); // 撤销
        }
    }
}