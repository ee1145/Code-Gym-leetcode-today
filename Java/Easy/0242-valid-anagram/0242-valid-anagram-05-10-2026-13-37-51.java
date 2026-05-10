class Solution {
    public boolean isAnagram(String s, String t) {
        //corner case:
        if (s.length() != t.length()) {
            return false;
        }

        //HashMap named counts
        Map<Character, Integer> counts = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            //s
            counts.put(s.charAt(i), counts.getOrDefault(s.charAt(i), 0) + 1);
            //t
            counts.put(t.charAt(i), counts.getOrDefault(t.charAt(i), 0) - 1);
        }

        for (int num : counts.values()) {
            if (num != 0) {
                return false;
            }
        }
        return true;
    }
}