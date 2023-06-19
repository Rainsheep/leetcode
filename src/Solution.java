import java.util.HashMap;
import java.util.List;

class Solution {

    HashMap<String, String> father = new HashMap<>();
    HashMap<String, Double> flag = new HashMap<>();

    private String findFather(String s) {
        if (!father.containsKey(s)) {
            father.put(s, s);
            flag.put(s, 1.0);
        } else {
            if (father.get(s).equals(s)) {
                return s;
            }

            String f = findFather(father.get(s));
            flag.put(s, flag.get(s) * flag.get(father.get(s)));
            father.put(s, f);
        }
        return father.get(s);
    }

    private void merge(String a, String b, double value) {
        String fatherA = findFather(a);
        String fatherB = findFather(b);
        if (!fatherA.equals(fatherB)) {
            father.put(fatherA, fatherB);
            flag.put(fatherA, value * flag.get(b) / flag.get(a) * flag.get(fatherB));
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int i = 0;
        for (List<String> equation : equations) {
            merge(equation.get(0), equation.get(1), values[i++]);
        }

        int size = queries.size();
        double[] res = new double[size];
        i = 0;
        for (List<String> query : queries) {
            if (!father.containsKey(query.get(0)) || !father.containsKey(query.get(1))) {
                res[i++] = -1.0;
                continue;
            }

            String fa = findFather(query.get(0));
            String fb = findFather(query.get(1));
            if (!fa.equals(fb)) {
                res[i++] = -1.0;
            } else {
                res[i++] = flag.get(query.get(0)) / flag.get(query.get(1));
            }
        }

        return res;
    }
}