class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode t;
        t = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(t);
        return root;

    }
}