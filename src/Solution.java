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

    ArrayList<TreeNode> list = new ArrayList<>();

    public void recoverTree(TreeNode root) {
        dfs(root);
        int[] indexs = find(list);
        int t = list.get(indexs[0]).val;
        list.get(indexs[0]).val = list.get(indexs[1]).val;
        list.get(indexs[1]).val = t;
        return;

    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        list.add(root);
        dfs(root.right);
    }

    private int[] find(List<TreeNode> list) {
        int f1 = -1, f2 = -1;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).val > list.get(i + 1).val) {
                f2 = i + 1;
                if (f1 == -1) {
                    f1 = i;
                } else {
                    break;
                }
            }
        }
        return new int[]{f1, f2};
    }
}