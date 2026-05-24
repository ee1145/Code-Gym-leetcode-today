class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return true;
            }

            // 关键：处理重复元素，无法判断哪段有序
            if (nums[left] == nums[mid]) {
                left++;                          // 安全缩小
            } else if (nums[left] < nums[mid]) { // 左半段有序
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;             // target 在左边
                } else {
                    left = mid + 1;              // target 在右边
                }
            } else {                             // 右半段有序
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;              // target 在右边
                } else {
                    right = mid - 1;             // target 在左边
                }
            }
        }
        return false;
    }
}
