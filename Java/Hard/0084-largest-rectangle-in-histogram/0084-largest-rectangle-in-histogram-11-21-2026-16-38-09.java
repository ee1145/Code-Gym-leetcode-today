class Solution {
    public int largestRectangleArea(int[] heights) {
        //mono stack only store indices
        int n = heights.length;
        int max = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                int height = heights[stack.pop()];
                int left = stack.isEmpty() ? -1 : stack.peek();
                max = Math.max(max, height * (i - left - 1));
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int height = heights[stack.pop()];
            int left = stack.isEmpty() ? -1 : stack.peek();
            max = Math.max(max, height * (n - left - 1));
        }
        return max;
    }
}