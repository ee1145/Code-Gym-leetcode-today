class MedianFinder {
    
    private PriorityQueue<Integer> leftMax;
    private PriorityQueue<Integer> rightMin;

    public MedianFinder() {
        leftMax  = new PriorityQueue<>((a, b) -> Integer.compare(b, a)); // Max-Heap
        rightMin = new PriorityQueue<>();                        // Min-Heap
    }

    public void addNum(int num) {
        // 第一步：先加入____堆
        leftMax.offer(num);

        // 第二步：修复"值" → 左堆堆顶必须 <= 右堆堆顶
        if (!rightMin.isEmpty() && leftMax.peek() > rightMin.peek()) {
            rightMin.offer(leftMax.poll());
        }

        // 第三步：修复"大小" → 左堆最多比右堆多1个
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
        return leftMax.peek();
    }
}