class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            // 计算以速度mid吃完所有香蕉需要多少小时
            int hours = 0;
            for (int pile : piles) {
                hours += (pile + mid - 1) / mid;
            }
            
            if (hours <= h) {
                right = mid;  // 速度够用，试试更慢
            } else {
                left = mid + 1;  // 速度不够，需要更快
            }
        }
        
        return left;
    }
}