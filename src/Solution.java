import java.util.HashMap;

class Solution {

    HashMap<Integer, Integer> parent;

    private void merge(int x, int y) {
        int pa = find(x);
        int pb = find(y);
        if (pa < pb) {
            parent.put(pb, pa);
        } else {
            parent.put(pa, pb);
        }
    }

    private int find(int x) {
        int p = parent.get(x) == x ? x : find(parent.get(x));
        parent.put(x, p);
        return p;
    }

    public int longestConsecutive(int[] nums) {
        parent = new HashMap<>();
        for (int num : nums) {
            parent.put(num, num);
        }

        for (int num : nums) {
            if (parent.containsKey(num - 1)) {
                merge(num - 1, num);
            }
        }
        int ans = 0;
        for (int num : nums) {
            ans = Math.max(ans, num - find(num) + 1);
        }
        return ans;
    }
}