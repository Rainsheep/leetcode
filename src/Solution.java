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

    int ans;

    public int maxPathSum(TreeNode root) {
        ans = root.val;
        dfs(root);
        return ans;

    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return -1;
        }

        int leftMax = dfs(root.left);
        int rightMax = dfs(root.right);
        int maxVal = Math.max(leftMax, rightMax);
        int res = root.val + Math.max(maxVal, 0);

        if (leftMax > 0 && rightMax > 0) {
            ans = Math.max(ans, leftMax + rightMax + root.val);
        } else {
            ans = Math.max(ans, res);
        }

        return res;
    }
}