import java.util.HashMap;

class Solution {

    HashMap<Integer, Integer> map = new HashMap<>();

    public int longestConsecutive(int[] nums) {
        for (int num : nums) {
            map.putIfAbsent(num, num);
            if (map.get(num - 1) != null) {
                merge(num, num - 1);
            }
            if (map.get(num + 1) != null) {
                merge(num, num + 1);
            }
        }

        int ans = 0;
        for (int num : nums) {
            ans = Math.max(num - find(num) + 1, ans);
        }
        return ans;
    }

    private int find(int x) {
        if (map.get(x) == x) {
            return x;
        }
        int res = find(map.get(x));
        map.put(x, res);
        return res;
    }

    private void merge(int x, int y) {
        int xParent = find(x);
        int yParent = find(y);
        if (xParent != yParent) {
            if (xParent < yParent) {
                map.put(yParent, xParent);
            } else {
                map.put(xParent, yParent);
            }
        }
    }

    public static void main(String[] args) {
        new Solution().longestConsecutive(new int[]{100, 4, 200, 1, 3, 2});
    }
}