class Solution {
    private static final int MOD = 1_000_000_007;
    
    public int zigZagArrays(int n, int l, int r) {
        int size = r - l + 1;
        
        // dp0[i] = 当前位置值为l+i，且比前一个小（下降）的方案数
        // dp1[i] = 当前位置值为l+i，且比前一个大（上升）的方案数
        int[] dp0 = new int[size]; // 下降
        int[] dp1 = new int[size]; // 上升
        int[] pre0 = new int[size + 1]; // dp0的前缀和
        int[] pre1 = new int[size + 1]; // dp1的前缀和
        
        // 初始化：第一个位置每个值各1种
        for (int i = 0; i < size; i++) {
            dp0[i] = 1;
            dp1[i] = 1;
            pre0[i + 1] = i + 1;
            pre1[i + 1] = i + 1;
        }
        
        for (int pos = 1; pos < n; pos++) {
            int[] newDp0 = new int[size];
            int[] newDp1 = new int[size];
            
            for (int i = 0; i < size; i++) {
                // 下降：前一个比当前大，且前一个是上升的
                newDp0[i] = (pre1[size] - pre1[i + 1] + MOD) % MOD;
                // 上升：前一个比当前小，且前一个是下降的
                newDp1[i] = pre0[i];
            }
            
            // 更新前缀和
            for (int i = 0; i < size; i++) {
                pre0[i + 1] = (pre0[i] + newDp0[i]) % MOD;
                pre1[i + 1] = (pre1[i] + newDp1[i]) % MOD;
            }
            
            dp0 = newDp0;
            dp1 = newDp1;
        }
        
        return (pre0[size] + pre1[size]) % MOD;
    }
}