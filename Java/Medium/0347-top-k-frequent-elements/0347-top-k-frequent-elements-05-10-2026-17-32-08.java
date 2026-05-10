class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 第一步：统计频率
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 第二步：小顶堆，按频率排序
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> map.get(a) - map.get(b)
        );

        for (int num : map.keySet()) {
            pq.offer(num);
            if (pq.size() > k) {
                pq.poll();   // ✅ 踢掉频率最小的
            }
        }

        // 第三步：取出结果
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = pq.poll();   // ✅ 从堆顶一个个取出
        }
        return result;
    }
}
