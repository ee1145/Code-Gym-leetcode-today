class Solution {
    
    private int dist(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>(
            (a, b) -> Integer.compare(dist(b), dist(a))  // Max-Heap
        );

        for (int[] point : points) {
            heap.offer(point);
            if (heap.size() > k) heap.poll();
        }

        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = heap.poll();
        }
        return result;
    }
}
