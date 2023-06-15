import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums) {
            if (list.isEmpty() || num > list.get(list.size() - 1)) {
                list.add(num);
            }
            if (num == list.get(list.size() - 1)) {
                continue;
            }
            int index = Collections.binarySearch(list, num);
            if (index < 0) {
                index = -index - 1;
            }
            list.set(index, num);
        }
        return list.size();
    }
}
