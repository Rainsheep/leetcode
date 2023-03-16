class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {

    public TreeNode convertBST(TreeNode root) {
        dfs(root, 0);
        return root;

    }

    private int dfs(TreeNode root, int parentVal) {
        if (root == null) {
            return parentVal;
        }
        int rootVal = root.val;
        int rightVal = dfs(root.right, parentVal);
        root.val = rightVal + rootVal;
        int leftVal = dfs(root.left, root.val);

        return leftVal;
    }
}