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

public class Codec {

    // Serialize using preorder traversal
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfsSerialize(root, sb);
        return sb.toString();
    }

    private void dfsSerialize(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("N,");
            return;
        }

        sb.append(node.val).append(",");
        dfsSerialize(node.left, sb);
        dfsSerialize(node.right, sb);
    }

    // Deserialize back to tree
    public TreeNode deserialize(String data) {
        String[] values = data.split(",");
        int[] index = new int[1];   // acts like a pointer
        return dfsDeserialize(values, index);
    }

    private TreeNode dfsDeserialize(String[] values, int[] index) {

        if (values[index[0]].equals("N")) {
            index[0]++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(values[index[0]]));
        index[0]++;

        node.left = dfsDeserialize(values, index);
        node.right = dfsDeserialize(values, index);

        return node;
    }
}
