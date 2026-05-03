class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Integer, Integer> count = new HashMap<>();

        s.codePoints().forEach(cp -> {
            count.put(cp, count.getOrDefault(cp, 0) + 1);
        });

        t.codePoints().forEach(cp -> {
            count.put(cp, count.getOrDefault(cp, 0) - 1);
        });

        for (int value : count.values()) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }
}