class Solution {
    public int lastStoneWeight(int[] stones) {
        // 创建最大堆（默认是最小堆，用 (a,b)->b-a 反转）
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        
        // 把所有石头加入最大堆
        for (int stone : stones) {
            maxHeap.offer(stone);
        }
        
        // 模拟游戏过程
        while (maxHeap.size() > 1) {
            int y = maxHeap.poll(); // 最重的石头
            int x = maxHeap.poll(); // 第二重的石头
            
            if (x != y) {
                maxHeap.offer(y - x); // 只有不相等才放回差值
            }
            // 相等则两块都销毁，不放回
        }
        
        // 堆为空返回0，否则返回最后一块石头
        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
}
