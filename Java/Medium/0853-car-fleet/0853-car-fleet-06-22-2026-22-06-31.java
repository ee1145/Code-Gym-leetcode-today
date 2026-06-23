class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        
        // 把位置和速度配对，按位置从大到小排序
        int[][] cars = new int[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars, (a, b) -> b[0] - a[0]);
        
        // 用栈记录每个车队的到达时间
        Deque<Double> stack = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
            double time = (double)(target - cars[i][0]) / cars[i][1];
            
            // 如果当前车比栈顶慢（时间更长），是新车队
            if (stack.isEmpty() || time > stack.peek()) {
                stack.push(time);
            }
            // 如果当前车比栈顶快（时间更短），会追上前面，合并，不压栈
        }
        
        return stack.size();
    }
}