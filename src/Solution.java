import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

class Solution {

    HashMap<String, String> father = new HashMap<>();
    HashMap<String, Double> multi = new HashMap<>();

    private void merge(String a, String b, double val) {
        String fa = findFather(a);
        String fb = findFather(b);
        if (!fa.equals(fb)) {
            father.put(fa, fb);
            multi.put(fa, val * multi.get(b) / multi.get(a));
        }
    }

    private String findFather(String x) {
        String fx = father.get(x);
        if (fx == null) {
            return null;
        }

        if (fx.equals(x)) {
            return x;
        }
        String fatherfx = findFather(fx);
        father.put(x, fatherfx);
        multi.put(x, multi.get(x) * multi.get(fx));
        return fatherfx;
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int i = 0;
        for (List<String> equation : equations) {
            init(equation.get(0));
            init(equation.get(1));
            merge(equation.get(0), equation.get(1), values[i++]);
        }

        // printMulti();

        double[] ans = new double[queries.size()];
        i = 0;
        for (List<String> query : queries) {
            String father1 = findFather(query.get(0));
            String father2 = findFather(query.get(1));
            // System.out.println(father1 + " " + father2);
            ans[i++] = father1 != null && father1.equals(father2) ? multi.get(query.get(0)) / multi.get(
                    query.get(1)) : -1.0;
        }

        return ans;
    }

    private void printMulti() {
        for (Entry<String, Double> entry : multi.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    private void init(String x) {
        if (!father.containsKey(x)) {
            father.put(x, x);
            multi.put(x, 1.0);
        }
    }
}