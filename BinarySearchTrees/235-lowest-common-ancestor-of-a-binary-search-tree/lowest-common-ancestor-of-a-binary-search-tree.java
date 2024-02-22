/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        TreeNode current = root;
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(current.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(current.right, p, q);
        }
        return root;
    }
}