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

    public void flatten(TreeNode root) {
        dfs(root);
        for (int i = 0; i < list.size(); i++) {
            TreeNode now = list.get(i);
            now.left = null;
            now.right = i == list.size() - 1 ? null : list.get(i + 1);
        }
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(root);
        dfs(root.left);
        dfs(root.right);
    }
}