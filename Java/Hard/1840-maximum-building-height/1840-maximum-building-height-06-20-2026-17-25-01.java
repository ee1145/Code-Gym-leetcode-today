class Solution {
    public int maxBuilding(int n, int[][] restrictions) {
        List<int[]> list = new ArrayList<>(Arrays.asList(restrictions));
        list.add(new int[] {1, 0});
        list.add(new int[] {n, n - 1});
        list.sort((a, b) -> a[0] - b[0]);

        int size = list.size();

        for (int i = 1; i < size; i++) {
            int[] prev = list.get(i - 1);
            int[] curr = list.get(i);
            int maxPossibleValue = prev[1] + (curr[0] - prev[0]);
            curr[1] = Math.min(curr[1], maxPossibleValue);
        }

        //right -> left
        for (int i = size - 2; i >= 0 ; i--) {
            int[] next = list.get(i + 1);
            int[] curr = list.get(i);
            int maxPossibleValue = next[1] + (next[0] - curr[0]);
            curr[1] = Math.min(curr[1], maxPossibleValue);
        }

        //calculate
        int ans = 0;
        for (int i = 1; i < size; i++) {
            int[] prev = list.get(i - 1);
            int[] curr = list.get(i);
            int dist = curr[0] - prev[0];
            int peak = (prev[1] + curr[1] + dist) / 2;
            ans = Math.max(ans, peak);
        }

        return ans;
    }
}