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
        maxHeightTree(root);
        return result;
    }

    private int maxHeightTree(TreeNode node){
        if (node == null){
            return 0;
        }        

        int leftHeight = maxHeightTree(node.left);
        int rightHeight = maxHeightTree(node.right);

        result = Math.max(result, leftHeight + rightHeight);

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
