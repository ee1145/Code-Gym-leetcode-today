class Solution {
    public int maxBuilding(int n, int[][] restrictions) {
        // 第一步：转成List方便排序和插入
        List<int[]> list = new ArrayList<>(Arrays.asList(restrictions));
        
        // 加入两个虚拟边界点：楼1高度0，楼n不限高
        list.add(new int[]{1, 0});
        list.add(new int[]{n, n - 1});
        
        // 按楼号排序
        list.sort((a, b) -> a[0] - b[0]);
        
        int size = list.size();
        
        // 第二步：从左到右，正向收缩
        for (int i = 1; i < size; i++) {
            int[] prev = list.get(i - 1);
            int[] cur = list.get(i);
            int maxPossible = prev[1] + (cur[0] - prev[0]);
            cur[1] = Math.min(cur[1], maxPossible);
        }
        
        // 第三步：从右到左，反向收缩
        for (int i = size - 2; i >= 0; i--) {
            int[] cur = list.get(i);
            int[] next = list.get(i + 1);
            int maxPossible = next[1] + (next[0] - cur[0]);
            cur[1] = Math.min(cur[1], maxPossible);
        }
        
        // 第四步：相邻两点之间找峰值
        int ans = 0;
        for (int i = 1; i < size; i++) {
            int[] prev = list.get(i - 1);
            int[] cur = list.get(i);
            int dist = cur[0] - prev[0];
            int peak = (prev[1] + cur[1] + dist) / 2;
            ans = Math.max(ans, peak);
        }
        
        return ans;
    }
}