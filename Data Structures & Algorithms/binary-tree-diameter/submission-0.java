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
    private int result;
    public int diameterOfBinaryTree(TreeNode root) {
        heightTree(root);
        return result;
    }

    private int heightTree(TreeNode node){
        if (node == null){
            return 0;
        }        

        int leftHeight = heightTree(node.left);
        int rightHeight = heightTree(node.right);

        result = Math.max(result, leftHeight + rightHeight);
        
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
