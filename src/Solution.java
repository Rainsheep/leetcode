import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {

    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums) {
            if (list.isEmpty() || num > list.get(list.size() - 1)) {
                list.add(num);
            } else {
                list.set(findIndex(list, num), num);
            }
        }

        return list.size();
    }

    private int findIndex(List<Integer> list, int target) {
        int index = Collections.binarySearch(list, target);
        return index >= 0 ? index : -index - 1;
    }
}