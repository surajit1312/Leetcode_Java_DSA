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
    /**
     * TC: O(4 x N) ~ O(N)
     * SC: O(H), where H is the depth of Binary Tree
     */
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        // Base case
        if (root1 == null) {
            return root2 == null;
        }
        if (root2 == null) {
            return root1 == null;
        }
        return root1.val == root2.val && 
            (flipEquiv(root1.left, root2.left) || flipEquiv(root1.left, root2.right)) &&
            (flipEquiv(root1.right, root2.right) || flipEquiv(root1.right, root2.left));
    }
}
