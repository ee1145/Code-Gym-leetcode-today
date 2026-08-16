class KthLargest {
    
    private PriorityQueue<Integer> minHeap; // 最小堆
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>(); // 默认就是最小堆
        
        for (int num : nums) {
            add(num); // 复用 add 方法初始化
        }
    }
    
    public int add(int val) {
        minHeap.offer(val); // 加入新值
        
        // 保持堆的大小为 k
        if (minHeap.size() > k) {
            minHeap.poll(); // 弹出最小值
        }
        
        return minHeap.peek(); // 堆顶就是第 k 大
    }
}
