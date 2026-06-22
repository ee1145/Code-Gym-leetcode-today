class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] count = new int[26];
        for (char c : text.toCharArray()) {
            count[c - 'a']++;
        }

        int[] needed = {
            count['b' - 'a'],
            count['a' - 'a'],
            count['l' - 'a'] / 2,
            count['o' - 'a'] / 2,
            count['n' - 'a']
        };

        int ans = Integer.MAX_VALUE;
        for (int n : needed) {
            ans = Math.min(ans, n);
        }
        return ans;
    }
}