class Solution {
    public boolean isAnagram(String s, String t) {
        //corner case check
        if (s.length() != t.length()) {
            return false;
        }

        //we should have a list[]
        int[] helperList = new int[26];

        for (int i = 0; i < s.length(); i++) {
            helperList[s.charAt(i) - 'a']++;
            helperList[t.charAt(i) - 'a']--;
        }

        for (int num : helperList) {
            if (num != 0) {
                return false;
            }
        }
        return true;
    }
}