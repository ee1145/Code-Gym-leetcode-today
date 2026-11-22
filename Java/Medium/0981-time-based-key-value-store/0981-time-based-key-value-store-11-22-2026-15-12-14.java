/*
Hashmap
Key: String, example "foo"
value: Entry{timestamp, string}, like {1, "bar"}
example:

"foo" -> [Entry{1, "bar"}, Entry{2, "bar2"}]
*/

class TimeMap {

    private record Entry(Integer time, String value) {}

    private final Map<String, List<Entry>> map = new HashMap<>();

    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Entry(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        List<Entry> list = map.getOrDefault(key, List.of());
        int left = 0;
        int right = list.size() - 1;
        String res = "";
        while(left<=right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid).time() <= timestamp) {
                res = list.get(mid).value();
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */