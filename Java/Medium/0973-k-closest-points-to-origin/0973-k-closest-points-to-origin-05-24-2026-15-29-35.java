class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Max-Heap：距离大的在堆顶
        PriorityQueue<int[]> heap = new PriorityQueue<>(
            (a, b) -> (b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0] + a[1]*a[1])
        );

        for (int[] point : points) {
            heap.offer(point);
            if (heap.size() > k) {
                heap.poll(); // 踢掉距离最远的
            }
        }

        // 把堆里的结果收集起来
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = heap.poll();
        }
        return result;
    }
}
