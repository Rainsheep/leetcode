import java.util.HashMap;
import java.util.Map;

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

    private Map<Integer, Integer> indexMap;

    // preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]  输出: [3,9,20,null,null,15,7]
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        // 构造哈希映射，帮助我们快速定位根节点
        indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }

        return genTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode genTree(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preLeft]);
        int index = indexMap.get(preorder[preLeft]);
        int leftChildNum = index - inLeft;
        root.left = genTree(preorder, inorder, preLeft + 1, preLeft + leftChildNum, inLeft, index - 1);
        root.right = genTree(preorder, inorder, preLeft + leftChildNum + 1, preRight, index + 1, inRight);
        return root;
    }
}