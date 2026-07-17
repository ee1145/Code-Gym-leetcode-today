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
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }
    
    private int height(TreeNode node) {
        if (node == null) return 0;
        
        int left = height(node.left);
        if (left == -1) return -1;  // 左子树不平衡，直接返回
        
        int right = height(node.right);
        if (right == -1) return -1;  // 右子树不平衡，直接返回
        
        // 当前节点高度差 > 1，不平衡
        if (Math.abs(left - right) > 1) return -1;
        
        // 返回当前节点高度
        return Math.max(left, right) + 1;
    }
}