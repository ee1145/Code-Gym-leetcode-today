class MedianFinder {
    
    private PriorityQueue<Integer> leftMax;  // Max-Heap，存左半边（较小的数）
    private PriorityQueue<Integer> rightMin; // Min-Heap，存右半边（较大的数）

    public MedianFinder() {
        leftMax  = new PriorityQueue<>((a, b) -> Integer.compare(b, a)); // Max-Heap
        rightMin = new PriorityQueue<>();                                  // Min-Heap（默认）
    }

    public void addNum(int num) {
        // 第一步：先加入左堆
        leftMax.offer(num);

        // 第二步：平衡 → 左堆堆顶必须 <= 右堆堆顶
        if (!rightMin.isEmpty() && leftMax.peek() > rightMin.peek()) {
            rightMin.offer(leftMax.poll());
        }

        // 第三步：平衡大小 → 左堆最多比右堆多1个
        if (leftMax.size() > rightMin.size() + 1) {
            rightMin.offer(leftMax.poll());
        } else if (rightMin.size() > leftMax.size()) {
            leftMax.offer(rightMin.poll());
        }
    }

    public double findMedian() {
        if (leftMax.size() == rightMin.size()) {
            return (leftMax.peek() + rightMin.peek()) / 2.0;
        }
        return leftMax.peek(); // 左堆多一个，堆顶就是中位数
    }
}
