class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        arr[0] = 1; // 第一个必须是1
        
        for (int i = 1; i < arr.length; i++) {
            // 每个位置最多比前一个多1
            arr[i] = Math.min(arr[i], arr[i-1] + 1);
        }
        
        return arr[arr.length - 1];
    }
}