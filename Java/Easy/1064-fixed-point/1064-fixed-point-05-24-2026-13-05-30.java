class Solution {
    public int fixedPoint(int[] arr) {
        int left = 0, right = arr.length - 1;
        int ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == mid) {
                ans = mid;          // 记录答案
                right = mid - 1;   // 继续往左找更小的
            } else if (arr[mid] < mid) {
                left = mid + 1;    // diff < 0，往右走
            } else {
                right = mid - 1;   // diff > 0，往左走
            }
        }

        return ans;
    }
}
