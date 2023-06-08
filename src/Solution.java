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

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                // 找到最后的结点
                TreeNode lastNode = curr.left;
                while (lastNode.right != null) {
                    lastNode = lastNode.right;
                }

                TreeNode t = curr.right;
                curr.right = curr.left;
                curr.left = null;
                lastNode.right = t;
            }
            curr = curr.right;
        }
    }
}