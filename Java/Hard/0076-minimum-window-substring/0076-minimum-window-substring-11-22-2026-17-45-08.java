class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }

        int[] need = new int[128];
        for (char c : t.toCharArray()) {
            need[c]++;
        }

        int missing = t.length();
        int left = 0;
        int bestStart = 0;
        int bestLen = Integer.MAX_VALUE;

        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            if (need[rightChar] > 0) {
                missing--;            // 这个字符是需要的，缺的少一个
            }
            need[rightChar]--;

            // 窗口合法，尽量缩小
            while (missing == 0) {
                int windowLen = right - left + 1;
                if (windowLen < bestLen) {
                    bestLen = windowLen;
                    bestStart = left;
                }

                char leftChar = s.charAt(left);
                need[leftChar]++;
                if (need[leftChar] > 0) {
                    missing++;        // 扔掉了一个需要的字符，又缺了
                }
                left++;
            }
        }

        if (bestLen == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(bestStart, bestStart + bestLen);
    }
}