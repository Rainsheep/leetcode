import java.util.LinkedList;
import java.util.List;

class Solution {

    private static int[] mut;

    public String getPermutation(int n, int k) {
        mut(n);

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i + 1);
        }
        return fun(list, k);
    }

    private String fun(List<Integer> list, int k) {
        int n = list.size();
        if (n == 1) {
            return list.get(0) + "";
        }
        int perNum = mut[n] / n;

        int index = (k - 1) / perNum;
        Integer ret = list.get(index);
        list.remove(index);

        return ret + fun(list, k - index * perNum);
    }

    private void mut(int n) {
        mut = new int[n + 1];
        int ret = 1;
        for (int i = 1; i <= n; i++) {
            ret *= i;
            mut[i] = ret;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().getPermutation(1, 1));
    }
}