import java.util.HashMap;
import java.util.List;

class Solution {

    HashMap<String, String> father = new HashMap<>();
    HashMap<String, Double> multiple = new HashMap<>();

    private void merge(String a, String b, double val) {
        // a/b=val
        String father1 = findFather(a);
        String father2 = findFather(b);
        if (!father1.equals(father2)) {
            father.put(father1, father2);
            multiple.put(father1, val * multiple.get(b) / multiple.get(a));
        }
    }

    private String findFather(String s) {
        String p = this.father.get(s);
        if (p == null || s.equals(p)) {
            return s;
        }

        String pp = findFather(p);
        // 压缩的同时更新倍数
        multiple.put(s, multiple.get(s) * multiple.get(p));
        father.put(s, pp);
        return pp;
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        int i = 0;
        for (List<String> equation : equations) {
            for (String s : equation) {
                if (!father.containsKey(s)) {
                    father.put(s, s);
                    multiple.put(s, 1.0);
                }

            }
            merge(equation.get(0), equation.get(1), values[i++]);
        }

        double[] ans = new double[queries.size()];
        i = 0;
        for (List<String> query : queries) {
            String a = findFather(query.get(0));
            String b = findFather(query.get(1));

            if (multiple.get(query.get(0)) == null) {
                ans[i++] = -1.0;
            } else {
                ans[i++] = a.equals(b) ? multiple.get(query.get(0)) / multiple.get(query.get(1)) : -1.0;
            }

        }
        return ans;
    }
}