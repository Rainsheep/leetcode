class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {

    TreeNode res;
    int resDeep = 0;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        res = root;
        dfs(root, p, q, 0);
        return res;
    }

    private boolean[] dfs(TreeNode root, TreeNode p, TreeNode q, int deep) {
        if (root == null) {
            return new boolean[]{false, false};
        }
        boolean[] bLeft = dfs(root.left, p, q, deep + 1);
        boolean[] bRight = dfs(root.right, p, q, deep + 1);
        boolean[] booleans = {bLeft[0] || bRight[0] || root == p, bLeft[1] || bRight[1] || root == q};
        if (booleans[0] && booleans[1] && deep > resDeep) {
            res = root;
            resDeep = deep;
        }
        return booleans;
    }
}