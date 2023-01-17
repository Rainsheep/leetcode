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
        return generateTree(1, n);
    }

    private List<TreeNode> generateTree(int left, int right) {
        ArrayList<TreeNode> res = new ArrayList<>();
        if (left > right) {
            res.add(null);
            return res;
        }
        for (int i = left; i <= right; i++) {
            List<TreeNode> lefts = generateTree(left, i - 1);
            List<TreeNode> rights = generateTree(i + 1, right);
            for (TreeNode leftNode : lefts) {
                for (TreeNode rightNode : rights) {
                    TreeNode node = new TreeNode(i);
                    node.left = leftNode;
                    node.right = rightNode;
                    res.add(node);
                }
            }
        }
        return res;
    }
}