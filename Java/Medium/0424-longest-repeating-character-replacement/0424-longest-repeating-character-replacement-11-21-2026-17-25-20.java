class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int left = 0;
        int maxCount = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            count[c - 'A']++;
            maxCount = Math.max(maxCount, count[c - 'A']);

            int windowLen = right - left + 1;
            if (windowLen - maxCount > k) {
                char leftChar = s.charAt(left);
                count[leftChar - 'A']--;
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}