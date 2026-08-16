class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // 最大堆：按距离²从大到小排列
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> (b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0] + a[1]*a[1])
        );

        for (int[] point : points) {
            maxHeap.offer(point);        // 加入新点

            if (maxHeap.size() > k) {
                maxHeap.poll();          // 弹出距离最远的点
            }
        }

        // 把堆里的 k 个点转成结果数组
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll();
        }
        return result;
    }
}
