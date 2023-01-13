import java.util.ArrayList;
import java.util.List;


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

    List<TreeNode> ans = new ArrayList<>();
    boolean[] flag;

    public List<TreeNode> generateTrees(int n) {
        flag = new boolean[n + 1];
        dfs(0, n, null);
        return ans;
    }

    private void dfs(int index, int n, TreeNode tree) {
        if (index == n) {
            insertList(tree);
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!flag[i]) {
                flag[i] = true;
                TreeNode copyTree = copyTree(tree);
                copyTree = insertNode(copyTree, i);
                dfs(index + 1, n, copyTree);
                flag[i] = false;
            }
        }

    }

    private TreeNode insertNode(TreeNode tree, int num) {
        if (tree == null) {
            return new TreeNode(num);
        }

        TreeNode pre = null;
        TreeNode p = tree;
        while (p != null) {
            pre = p;
            p = num > p.val ? p.right : p.left;
        }
        if (num > pre.val) {
            pre.right = new TreeNode(num);
        } else {
            pre.left = new TreeNode(num);
        }

        return tree;
    }

    private boolean isEqualsTree(TreeNode tree1, TreeNode tree2) {
        if (tree1 == null && tree2 == null) {
            return true;
        }
        if (tree1 == null || tree2 == null) {
            return false;
        }
        if (tree1.val != tree2.val) {
            return false;
        }
        return isEqualsTree(tree1.left, tree2.left) && isEqualsTree(tree1.right, tree2.right);
    }

    private void insertList(TreeNode tree) {
        for (TreeNode an : ans) {
            if (isEqualsTree(an, tree)) {
                return;
            }
        }
        ans.add(tree);
    }

    private TreeNode copyTree(TreeNode treeNode) {
        if (treeNode == null) {
            return null;
        }

        TreeNode res = new TreeNode(treeNode.val);
        res.left = copyTree(treeNode.left);
        res.right = copyTree(treeNode.right);
        return res;
    }

}