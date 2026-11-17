class Solution:
    def largestRectangleArea(self, heights: list[int]) -> int:
        max_area = 0
        stack = []                      # 存下标，对应高度从栈底到栈顶递增
        heights = heights + [0]         # 末尾补一根高度 0 的柱子，把栈清空

        for i, h in enumerate(heights):
            while stack and heights[stack[-1]] > h:
                height = heights[stack.pop()]
                left = stack[-1] if stack else -1
                width = i - left - 1
                max_area = max(max_area, height * width)
            stack.append(i)

        return max_area