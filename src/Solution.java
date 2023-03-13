import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Random;

class Solution {

    int[] ans;
    int ansLen;
    HashMap<Integer, Integer> map;

    public int[] topKFrequent(int[] nums, int k) {
        map = new HashMap<>();
        ansLen = 0;
        ans = new int[k];
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        ArrayList<Integer> list = new ArrayList<>(map.size());

        for (Entry<Integer, Integer> entry : map.entrySet()) {
            list.add(entry.getKey());
        }

        qsort(list, 0, list.size() - 1, k);
        return ans;
    }

    private void qsort(List<Integer> list, int start, int end, int k) {
        int pickIndex = new Random().nextInt(end - start + 1) + start;
        int pickVal = list.get(pickIndex);
        int index = start;
        for (int i = start; i <= end; i++) {
            if (map.get(list.get(i)) >= map.get(pickVal)) {
                Collections.swap(list, i, index++);
            }
        }

        if (k == index - start) {
            addToAns(list, start, index);
        } else if (index - start > k) {
            qsort(list, start, index - 1, k);
        } else {
            addToAns(list, start, index);
            qsort(list, index, end, k - (index - start));
        }
    }

    private void addToAns(List<Integer> list, int start, int end) {
        for (int i = start; i < end; i++) {
            ans[ansLen++] = list.get(i);
        }
    }
}