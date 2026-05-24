class Solution {
    int[] dp;
    int[] arr;
    int d;

    public int maxJumps(int[] arr, int d) {
        this.arr = arr;
        this.d = d;
        this.dp = new int[arr.length];
        
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            ans = Math.max(ans, dfs(i));
        }
        return ans;
    }

    private int dfs(int i) {
        if (dp[i] != 0) return dp[i];  // 已经算过了，直接返回
        
        dp[i] = 1;  // 至少能访问自己

        // 向右跳
        for (int x = 1; x <= d; x++) {
            int j = i + x;
            if (j >= arr.length) break;      // 越界，停止
            if (arr[j] >= arr[i]) break;     // 遇到障碍，停止
            dp[i] = Math.max(dp[i], 1 + dfs(j));
        }

        // 向左跳
        for (int x = 1; x <= d; x++) {
            int j = i - x;
            if (j < 0) break;                // 越界，停止
            if (arr[j] >= arr[i]) break;     // 遇到障碍，停止
            dp[i] = Math.max(dp[i], 1 + dfs(j));
        }

        return dp[i];
    }
}
