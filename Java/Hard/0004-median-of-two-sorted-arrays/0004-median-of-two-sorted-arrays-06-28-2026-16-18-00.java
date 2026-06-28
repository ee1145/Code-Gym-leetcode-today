class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 确保nums1是较短的数组，对较短的数组做二分
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int m = nums1.length, n = nums2.length;
        int left = 0, right = m;
        
        while (left <= right) {
            // i是nums1的切割点，j是nums2的切割点
            int i = left + (right - left) / 2;
            int j = (m + n + 1) / 2 - i;
            
            // 切割点左边的最大值，右边的最小值
            int nums1Left  = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int nums1Right = (i == m) ? Integer.MAX_VALUE : nums1[i];
            int nums2Left  = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int nums2Right = (j == n) ? Integer.MAX_VALUE : nums2[j];
            
            if (nums1Left <= nums2Right && nums2Left <= nums1Right) {
                // 找到正确的切割点！
                if ((m + n) % 2 == 1) {
                    // 奇数：左半部分最大值就是中位数
                    return Math.max(nums1Left, nums2Left);
                } else {
                    // 偶数：左半最大值和右半最小值的平均
                    return (Math.max(nums1Left, nums2Left) + 
                            Math.min(nums1Right, nums2Right)) / 2.0;
                }
            } else if (nums1Left > nums2Right) {
                // nums1切太靠右，往左移
                right = i - 1;
            } else {
                // nums1切太靠左，往右移
                left = i + 1;
            }
        }
        
        return 0.0;
    }
}