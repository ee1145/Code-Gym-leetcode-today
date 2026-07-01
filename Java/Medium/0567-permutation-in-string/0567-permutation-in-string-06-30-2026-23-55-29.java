class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        
        // 初始化s1的计数和s2第一个窗口的计数
        for (int i = 0; i < s1.length(); i++) {
            count1[s1.charAt(i) - 'a']++;
            count2[s2.charAt(i) - 'a']++;
        }
        
        // 判断第一个窗口是否匹配
        if (Arrays.equals(count1, count2)) return true;
        
        // 滑动窗口
        for (int right = s1.length(); right < s2.length(); right++) {
            // 加入右边新字符
            count2[s2.charAt(right) - 'a']++;
            // 移除左边旧字符
            count2[s2.charAt(right - s1.length()) - 'a']--;
            // 判断是否匹配
            if (Arrays.equals(count1, count2)) return true;
        }
        
        return false;
    }
}