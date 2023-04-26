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

    public List<TreeNode> generateTrees(int n) {
        return dfs(1, n);
    }

    private List<TreeNode> dfs(int begin, int end) {
        ArrayList<TreeNode> treeNodes = new ArrayList<>();
        if (begin > end) {
            treeNodes.add(null);
            return treeNodes;
        }

        for (int i = begin; i <= end; i++) {
            List<TreeNode> leftNodes = dfs(begin, i - 1);
            List<TreeNode> rightNodes = dfs(i + 1, end);

            for (TreeNode leftNode : leftNodes) {
                for (TreeNode rightNode : rightNodes) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    root.right = rightNode;
                    treeNodes.add(root);
                }
            }
        }
        return treeNodes;
    }
}