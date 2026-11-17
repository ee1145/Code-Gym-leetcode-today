class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length, max = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i <= n; i++) {
            int h = (i == n) ? 0 : heights[i];
            while (!stack.isEmpty() && heights[stack.peek()] > h) {
                int height = heights[stack.pop()];
                int left = stack.isEmpty() ? -1 : stack.peek();
                max = Math.max(max, height * (i - left - 1));
            }
            stack.push(i);
        }
        return max;
    }
}