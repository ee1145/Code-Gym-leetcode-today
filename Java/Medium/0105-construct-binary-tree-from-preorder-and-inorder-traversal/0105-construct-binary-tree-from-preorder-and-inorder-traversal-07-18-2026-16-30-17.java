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
    Map<Integer, Integer> indexMap = new HashMap<>();
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 把inorder每个值的下标存进map，方便O(1)查找
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1, 
                     inorder, 0, inorder.length - 1);
    }
    
    private TreeNode build(int[] preorder, int preStart, int preEnd,
                           int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) return null;
        
        // 前序第一个是根节点
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        
        // 在中序里找根节点位置
        int inIndex = indexMap.get(rootVal);
        
        // 左子树的节点数
        int leftSize = inIndex - inStart;
        
        // 递归建左子树
        root.left = build(preorder, preStart + 1, preStart + leftSize,
                          inorder, inStart, inIndex - 1);
        
        // 递归建右子树
        root.right = build(preorder, preStart + leftSize + 1, preEnd,
                           inorder, inIndex + 1, inEnd);
        
        return root;
    }
}