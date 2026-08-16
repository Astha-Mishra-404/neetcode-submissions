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

    // Index to track current root in preorder
    int preIndex = 0;

    // Stores value -> index mapping of inorder array
    HashMap<Integer, Integer> inorderIndex = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        // Build a map for fast lookup of root positions in inorder
        for (int i = 0; i < inorder.length; i++) {
            inorderIndex.put(inorder[i], i);
        }

        return build(preorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int left, int right) {

        // no elements to construct subtree
        if (left > right) return null;

        // current root value from preorder
        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);

        // index of root in inorder array
        int mid = inorderIndex.get(rootVal);

        // build left subtree
        root.left = build(preorder, left, mid - 1);

        // build right subtree
        root.right = build(preorder, mid + 1, right);

        return root;
    }
}