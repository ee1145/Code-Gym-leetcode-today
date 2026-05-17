class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //key: strings, value - list of strings
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            //sort string as key
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            map.putIfAbsent(key, new ArrayList<>());

            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
}