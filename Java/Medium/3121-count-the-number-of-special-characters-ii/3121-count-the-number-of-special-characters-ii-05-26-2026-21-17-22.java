class Solution {
    public int numberOfSpecialChars(String word) {
        // 记录每个字母最后一次小写出现的位置
        int[] lastLower = new int[26];
        // 记录每个字母第一次大写出现的位置
        int[] firstUpper = new int[26];
        
        // 初始化为 -1（表示未出现）
        Arrays.fill(lastLower, -1);
        Arrays.fill(firstUpper, -1);
        
        // 遍历字符串，记录位置
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (Character.isLowerCase(ch)) {
                // 更新最后一次小写出现的位置
                lastLower[ch - 'a'] = i;
            } else {
                // 只记录第一次大写出现的位置
                int idx = ch - 'A';
                if (firstUpper[idx] == -1) {
                    firstUpper[idx] = i;
                }
            }
        }
        
        // 统计 special 字母数量
        int count = 0;
        for (int i = 0; i < 26; i++) {
            // 两者都出现，且最后小写 < 第一次大写
            if (lastLower[i] != -1 && firstUpper[i] != -1 
                && lastLower[i] < firstUpper[i]) {
                count++;
            }
        }
        
        return count;
    }
}