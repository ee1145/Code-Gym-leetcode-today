class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        //count freq
        //key: String, word in words, value: Integer, freq
        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        //minHeap:
        PriorityQueue<String> pq = new PriorityQueue<>(
            (a, b) -> map.get(a).equals(map.get(b)) ?
                        b.compareTo(a) :
                        map.get(a) - map.get(b)
        );

        for (String word : map.keySet()) {
            pq.offer(word);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        //result:
        List<String> result = new LinkedList<>();
        while (!pq.isEmpty()) {
            result.add(0, pq.poll());
        }
        return result;
    }
}