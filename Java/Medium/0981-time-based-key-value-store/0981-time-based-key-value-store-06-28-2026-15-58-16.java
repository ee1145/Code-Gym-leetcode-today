class TimeMap {
    // 每个key对应一个列表，存[timestamp, value]对
    private Map<String, List<int[]>> timestamps;
    private Map<String, List<String>> values;

    public TimeMap() {
        timestamps = new HashMap<>();
        values = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        timestamps.computeIfAbsent(key, k -> new ArrayList<>()).add(new int[]{timestamp});
        values.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
    }
    
    public String get(String key, int timestamp) {
        if (!timestamps.containsKey(key)) return "";
        
        List<int[]> times = timestamps.get(key);
        int left = 0, right = times.size() - 1;
        int idx = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (times.get(mid)[0] <= timestamp) {
                idx = mid;        // 记录当前满足条件的位置
                left = mid + 1;   // 试试有没有更近的
            } else {
                right = mid - 1;
            }
        }
        
        return idx == -1 ? "" : values.get(key).get(idx);
    }
}