/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int maxSum = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }
    
    private int dfs(TreeNode node) {
        if (node == null) return 0;
        
        // 负数不如不选，取0
        int left = Math.max(0, dfs(node.left));
        int right = Math.max(0, dfs(node.right));
        
        // 经过当前节点的最大路径（可以拐弯）
        maxSum = Math.max(maxSum, left + node.val + right);
        
        // 返回给父节点的最大贡献（不能拐弯，只选一边）
        return node.val + Math.max(left, right);
    }
}