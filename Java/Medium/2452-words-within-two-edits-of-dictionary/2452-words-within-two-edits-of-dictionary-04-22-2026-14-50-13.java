class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        return Arrays.stream(queries).filter(q ->
        Arrays.stream(dictionary).anyMatch(d -> {
            int diff = 0;
            for (int i = 0; i < q.length(); i++) {
                if (q.charAt(i) != d.charAt(i)) {
                    diff++;
                }
            }
            return diff <= 2;
        })).collect(Collectors.toList());
    }
}