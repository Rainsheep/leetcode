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

    int ans = 0;
    int targetSum;

    public int pathSum(TreeNode root, int targetSum) {
        this.targetSum = targetSum;
        dfs(root, new ArrayList<>());
        return ans;
    }

    private void dfs(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        long sum = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            sum += list.get(i);
            if (sum == targetSum) {
                ans++;
            }
        }
        ArrayList<Integer> rightList = new ArrayList<>(list);
        dfs(root.left, list);
        dfs(root.right, rightList);
    }
}