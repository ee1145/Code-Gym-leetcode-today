class Solution {
    public List<String> topKFrequent(String[] words, int k) {

        // 第一步：统计频率
        Map<String, Integer> freq = new HashMap<>();
        for (String word : words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }

        // 第二步：Min-Heap，链式比较器，最优雅写法
        PriorityQueue<String> pq = new PriorityQueue<>(
            Comparator.comparingInt((String w) -> freq.get(w))
                    .thenComparing(Comparator.reverseOrder())
        );

        for (String word : freq.keySet()) {
            pq.offer(word);
            if (pq.size() > k) pq.poll();
        }

        // 第三步：倒序取出
        LinkedList<String> result = new LinkedList<>();
        while (!pq.isEmpty()) {
            result.addFirst(pq.poll());
        }

        return result;
    }
}