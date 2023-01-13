import java.util.ArrayList;

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

    ArrayList<TreeNode> list = new ArrayList<>();

    public void recoverTree(TreeNode root) {
        dfs(root);
        int index1 = -1;
        int index2 = -1;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).val < list.get(i - 1).val) {
                index2 = i;
                if (index1 == -1) {
                    index1 = i - 1;
                } else {
                    break;
                }
            }
        }

        int x = list.get(index1).val;
        int y = list.get(index2).val;

        list.get(index1).val = y;
        list.get(index2).val = x;


    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        list.add(root);
        dfs(root.right);
    }
}