class Solution {
    public boolean isAnagram(String s, String t) {
        //corner case check
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> counts = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            //s character + 1
            counts.put(s.charAt(i), counts.getOrDefault(s.charAt(i), 0) + 1);
            //t charactoer - 1
            counts.put(t.charAt(i), counts.getOrDefault(t.charAt(i), 0) - 1);
        }

        for (int val : counts.values()) {
            if (val != 0) {
                return false;
            }
        }
        return true;
    }
}