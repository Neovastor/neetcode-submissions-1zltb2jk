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
    public int count = 0;

    public int goodNodes(TreeNode root) {
        Deque<Integer> q = new ArrayDeque<>();

        check(root, q);
        return count;
    }
    private void check(TreeNode root, Deque<Integer> q){
        if (root == null){
            return;
        }

        // while (!q.isEmpty() && root.val < q.peekLast() ){
        //     q.pollLast();

        // }
        
        if (q.isEmpty() || q.peekLast() <= root.val){
            count++;
            
            q.addLast(root.val);
        }
    
        check(root.left, new ArrayDeque<>(q));
        check(root.right, new ArrayDeque<>(q));

    }
}
