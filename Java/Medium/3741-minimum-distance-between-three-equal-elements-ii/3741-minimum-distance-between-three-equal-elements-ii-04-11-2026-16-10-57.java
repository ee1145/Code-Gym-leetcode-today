class Solution {
    public int minimumDistance(int[] nums) {
                int n = nums.length;
        // 1. 记录每个数字出现的所有下标
        // 因为 nums[i] <= n，可以用 List 数组代替 HashMap 提高速度
        List<Integer>[] pos = new ArrayList[n + 1];
        for (int i = 0; i < n; i++) {
            if (pos[nums[i]] == null) {
                pos[nums[i]] = new ArrayList<>();
            }
            pos[nums[i]].add(i);
        }

        long minDist = Long.MAX_VALUE;
        boolean found = false;

        // 2. 遍历每个数字的下标列表
        for (int v = 1; v <= n; v++) {
            List<Integer> indices = pos[v];
            if (indices == null || indices.size() < 3) continue;

            // 3. 在当前数字的下标列表中，找相邻三个跨度最小的
            for (int i = 2; i < indices.size(); i++) {
                found = true;
                // 跨度 = indices.get(i) - indices.get(i-2)
                // 距离 = 2 * 跨度
                long currentDist = 2L * (indices.get(i) - indices.get(i - 2));
                minDist = Math.min(minDist, currentDist);
            }
        }

        return found ? (int) minDist : -1;
    }
    }
