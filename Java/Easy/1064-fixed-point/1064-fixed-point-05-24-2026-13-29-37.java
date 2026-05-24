class Solution {
    public int fixedPoint(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == mid) {
                ans = mid;
                right = mid - 1;
            } else if (arr[mid] < mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}