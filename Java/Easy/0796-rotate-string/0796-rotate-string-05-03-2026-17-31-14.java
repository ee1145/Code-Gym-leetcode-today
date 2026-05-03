class Solution {
    public boolean rotateString(String s, String goal) {
        // 如果两个字符串长度不同，显然无法通过旋转得到
        if (s.length() != goal.length()) {
            return false;
        }
        
        // 将 s 拼接自身，新的字符串包含了 s 所有可能的旋转结果
        String doubled = s + s;
        
        // 检查 goal 是否为拼接后字符串的子串
        return doubled.contains(goal);
    }
}