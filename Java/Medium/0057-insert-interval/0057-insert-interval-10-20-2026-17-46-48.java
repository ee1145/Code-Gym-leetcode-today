class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            if (newInterval[1] < intervals[i][0]) {
                // 新区间在当前区间左边：放新区间，再接上剩下的所有区间
                res.add(newInterval);
                for (int j = i; j < intervals.length; j++) {
                    res.add(intervals[j]);
                }
                return res.toArray(new int[0][]);
            } else if (newInterval[0] > intervals[i][1]) {
                // 当前区间在新区间左边：原样放入
                res.add(intervals[i]);
            } else {
                // 重叠：合并进 newInterval
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }
        }

        // 没提前返回：newInterval 在最右边，或者一直合并到了最后
        res.add(newInterval);
        return res.toArray(new int[0][]);
    }
}