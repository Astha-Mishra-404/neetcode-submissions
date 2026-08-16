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

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        // If subRoot is null, it is always a subtree
        if (subRoot == null) return true;

        // If root is null but subRoot is not, no match is possible
        if (root == null) return false;

        // Check if the trees match starting from this node
        if (isSame(root, subRoot)) return true;

        // Otherwise, try in left and right subtrees
        return isSubtree(root.left, subRoot) ||
               isSubtree(root.right, subRoot);
    }

    private boolean isSame(TreeNode p, TreeNode q) {

        // Both nodes are null -> same tree
        if (p == null && q == null) return true;

        // One is null or values are different
        if (p == null || q == null || p.val != q.val) return false;

        // Check left and right subtrees
        return isSame(p.left, q.left) &&
               isSame(p.right, q.right);
    }
}

