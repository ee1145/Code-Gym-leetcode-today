class Solution {

    public int maxDistance(int side, int[][] points, int k) {
        int n = points.length;
        long[] arr = new long[n];

        // 顺时针展开边界到一维轴
        for (int i = 0; i < n; i++) {
            int x = points[i][0], y = points[i][1];
            if (x == 0)         arr[i] = y;
            else if (y == side) arr[i] = (long) side + x;
            else if (x == side) arr[i] = 3L * side - y;
            else                arr[i] = 4L * side - x;
        }
        Arrays.sort(arr);

        // 二分答案
        int lo = 1, hi = side, ans = 0;
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            if (check(arr, side, k, mid)) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return ans;
    }

    private boolean check(long[] arr, int side, int k, long limit) {
        int n = arr.length;
        long perimeter = 4L * side;

        for (int s = 0; s < n; s++) {
            long start = arr[s];
            long end = start + perimeter - limit; // 最后一个点不能超过这里
            long cur = start;
            boolean ok = true;

            for (int i = 0; i < k - 1; i++) {
                // 找第一个 >= cur + limit 的位置
                int idx = lowerBound(arr, cur + limit);
                // 环形：若超出数组末尾，从头找（但值需加 perimeter）
                // 这里用 end 约束来等价处理环形
                if (idx == n || arr[idx] > end) {
                    ok = false;
                    break;
                }
                cur = arr[idx];
            }

            if (ok) return true;
        }
        return false;
    }

    // 在 arr 中找第一个 >= target 的下标
    private int lowerBound(long[] arr, long target) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (arr[mid] < target) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}
