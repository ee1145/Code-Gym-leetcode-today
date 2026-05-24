class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;      // 最小值在右边
            } else if (nums[mid] < nums[right]) {
                right = mid;         // 最小值在左边或就是 mid
            } else {
                right--;             // 无法判断，安全缩小右边界
            }
        }

        return nums[left];
    }
}
