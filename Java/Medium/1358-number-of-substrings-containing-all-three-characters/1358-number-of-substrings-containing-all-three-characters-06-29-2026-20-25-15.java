class Solution {
    public int numberOfSubstrings(String s) {
        int[] count = new int[3];
        int left = 0;
        int result = 0;
        
        for (int right = 0; right < s.length(); right++) {
            count[s.charAt(right) - 'a']++;
            
            // 收缩left，找到满足条件的最小left
            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                count[s.charAt(left) - 'a']--;
                left++;
            }
            
            // 此时left是第一个不满足条件的位置，left-1才是最小满足的位置
            // 所以有效起点数量是left（从0到left-1，共left个）
            result += left;
        }
        
        return result;
    }
}