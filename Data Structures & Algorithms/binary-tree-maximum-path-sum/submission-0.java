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

    // This will store the maximum path sum found anywhere in the tree
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    // Returns the maximum gain from this node going DOWN (one direction only)
    private int dfs(TreeNode node) {
        if (node == null) return 0;

        // Max gain from left and right subtrees
        int left = Math.max(0, dfs(node.left));
        int right = Math.max(0, dfs(node.right));

        // Path that passes through this node (can use both sides)
        int currentPath = node.val + left + right;

        // Update global maximum
        max = Math.max(max, currentPath);

        // Return the best single-branch path
        return node.val + Math.max(left, right);
    }
}