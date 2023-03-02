class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // System.out.println(dfs(root));
        return dfs(root);
    }

    private String dfs(TreeNode root) {
        if (root == null) {
            return "null";
        }
        String left = dfs(root.left);
        String right = dfs(root.right);

        return String.format("{%d,%s,%s}", root.val, left, right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return genNode(data);
    }

    private TreeNode genNode(String s) {
        if ("null".equals(s)) {
            return null;
        }
        String[] nodeStr = getNodeStr(s);
        TreeNode root = new TreeNode(Integer.parseInt(nodeStr[0]));
        root.left = genNode(nodeStr[1]);
        root.right = genNode(nodeStr[2]);
        return root;
    }

    private String[] getNodeStr(String s) {
        // System.out.println(s);
        s = s.substring(1, s.length() - 1);
        int k = 0;
        String[] res = new String[3];
        while (true) {
            if (s.charAt(k) == ',') {
                res[0] = s.substring(0, k++);
                break;
            }
            k++;
        }

        for (int i = 1; i <= 2; i++) {

            if (s.charAt(k) == 'n') {
                res[i] = "null";
                k += 5;
            } else {
                int begin = k;
                int left = 0;
                while (k != s.length()) {
                    if (s.charAt(k) == '{') {
                        left++;
                    } else if (s.charAt(k) == '}') {
                        left--;
                    }
                    k++;

                    if (left == 0) {
                        res[i] = s.substring(begin, k);
                        k += 1;
                        break;
                    }
                }
            }
        }

        return res;
    }
}