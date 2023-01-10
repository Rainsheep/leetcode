import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<Integer> grayCode(int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(0);
        ans.add(1);
        for (int i = 1; i < n; i++) {
            int size = ans.size();
            for (int j = size - 1; j >= 0; j--) {
                ans.add(ans.get(j) | (1 << i));
            }
        }
        return ans;
    }
}