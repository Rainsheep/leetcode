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
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left != null) {
                TreeNode next = cur.left;
                TreeNode preNode = next;
                while (preNode.right != null) {
                    preNode = preNode.right;
                }
                preNode.right = cur.right;
                cur.left = null;
                cur.right = next;
            }
            cur = cur.right;
        }

    }
}