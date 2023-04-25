import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<Integer> grayCode(int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(0);
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> t = new ArrayList<>(ans);
            for (int j = t.size() - 1; j >= 0; j--) {
                ans.add(t.get(j) + (1 << i));
            }
        }
        return ans;
    }
}