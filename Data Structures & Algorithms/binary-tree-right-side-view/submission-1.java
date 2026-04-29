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
    public List<Integer> rightSideView(TreeNode root) {
        //level order traversal
        Deque<TreeNode> q = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();
        if (root != null){
            q.add(root);
        }
        
        while (!q.isEmpty()){
            List<TreeNode> list = new ArrayList<>();

            while (!q.isEmpty()){
                list.add(q.pollFirst());
            }
            result.add(list.get(list.size() - 1).val);
            
            for (int i = 0; i < list.size(); i++){
                if (list.get(i).left != null){
                    q.add(list.get(i).left); 

                }
                if (list.get(i).right != null){
                    q.add(list.get(i).right); 

                }

            }
        }
        return result;
    }
}
