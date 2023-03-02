import java.util.ArrayList;
import java.util.Collections;

class Solution {

    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums) {
            if (list.isEmpty() || num > list.get(list.size() - 1)) {
                list.add(num);
            } else {
                int index = Collections.binarySearch(list, num);
                if (index < 0) {
                    list.set(-index - 1, num);
                }
            }
        }
        return list.size();
    }
}
