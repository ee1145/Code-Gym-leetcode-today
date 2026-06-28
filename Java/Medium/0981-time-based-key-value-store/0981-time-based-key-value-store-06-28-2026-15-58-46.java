class TimeMap {
    private Map<String, List<String>> valueMap;
    private Map<String, List<Integer>> timeMap;

    public TimeMap() {
        valueMap = new HashMap<>();
        timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        valueMap.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
        timeMap.computeIfAbsent(key, k -> new ArrayList<>()).add(timestamp);
    }
    
    public String get(String key, int timestamp) {
        if (!timeMap.containsKey(key)) return "";
        
        List<Integer> times = timeMap.get(key);
        int left = 0, right = times.size() - 1, idx = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (times.get(mid) <= timestamp) {
                idx = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return idx == -1 ? "" : valueMap.get(key).get(idx);
    }
}