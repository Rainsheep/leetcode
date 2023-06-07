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

    public void recoverTree(TreeNode root) {
        TreeNode p1 = null, p2 = null, pred = null, predTemp = null;

        while (root != null) {
            if (root.left != null) {
                predTemp = root.left;
                while (predTemp.right != null && predTemp.right != root) {
                    predTemp = predTemp.right;
                }

                if (predTemp.right == null) {
                    predTemp.right = root;
                    root = root.left;
                } else {
                    if (pred != null && root.val < pred.val) {
                        if (p1 == null) {
                            p1 = pred;
                        }
                        p2 = root;
                    }
                    pred = root;
                    root = root.right;
                    predTemp.right = null;
                }
            } else {
                if (pred != null && root.val < pred.val) {
                    if (p1 == null) {
                        p1 = pred;
                    }
                    p2 = root;
                }
                pred = root;
                root = root.right;
            }
        }
        swap(p1, p2);
    }

    public void swap(TreeNode x, TreeNode y) {
        int tmp = x.val;
        x.val = y.val;
        y.val = tmp;
    }
}
