class Solution {
    public int longestConsecutive(int[] nums) {
        // 第一步：把所有数放进 HashSet
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int ans = 0;

        // 第二步：只从序列起点开始数
        for (int num : set) {
            // num-1 不在集合里，说明 num 是起点
            if (!set.contains(num - 1)) {
                int cur = num;
                int len = 1;

                // 一直往后数，直到断掉
                while (set.contains(cur + 1)) {
                    cur++;
                    len++;
                }

                ans = Math.max(ans, len);
            }
        }

        return ans;
    }
}
