class Solution {
    public String minWindow(String s, String t) {
        int[] need = new int[128];   // t 里每个字母需要几个（固定不变）
        int[] have = new int[128];   // 窗口里每个字母有几个（随窗口变化）

        for (char c : t.toCharArray()) {
            need[c]++;
        }

        int left = 0;
        int bestStart = 0;
        int bestLen = Integer.MAX_VALUE;

        for (int right = 0; right < s.length(); right++) {
            have[s.charAt(right)]++;          // 放进窗口

            while (isEnough(have, need)) {    // 够了就缩
                int windowLen = right - left + 1;
                if (windowLen < bestLen) {
                    bestLen = windowLen;
                    bestStart = left;
                }
                have[s.charAt(left)]--;       // 扔出窗口
                left++;
            }
        }

        if (bestLen == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(bestStart, bestStart + bestLen);
    }

    // 窗口里每个字母的个数，都 >= t 需要的个数吗？
    private boolean isEnough(int[] have, int[] need) {
        for (int i = 0; i < 128; i++) {
            if (have[i] < need[i]) {
                return false;
            }
        }
        return true;
    }
}