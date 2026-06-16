class Solution {
    public String processStr(String s) {
        StringBuilder result = new StringBuilder();
        
        for (char c : s.toCharArray()) {
            if (c == '*') {
                // 删除最后一个字符
                if (result.length() > 0) {
                    result.deleteCharAt(result.length() - 1);
                }
            } else if (c == '#') {
                // 复制
                String current = result.toString();
                result.append(current);
            } else if (c == '%') {
                // 反转
                result.reverse();
            } else {
                // 普通字母，追加
                result.append(c);
            }
        }
        return result.toString();
    }
}