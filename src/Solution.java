import java.util.ArrayDeque;
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

    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> ret = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        int size = 0;
        if (root != null) {
            queue.add(root);
            size = 1;
        }
        while (!queue.isEmpty()) {
            TreeNode node = queue.pop();
            if (node.left != null) {
                queue.addLast(node.left);
            }
            if (node.right != null) {
                queue.addLast(node.right);
            }
            list.add(node.val);
            if (list.size() == size || queue.isEmpty()) {
                size = queue.size();
                ret.add(list);
                list = new ArrayList<>();
            }
        }
        return ret;

    }
}