import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Random;

class Solution {

    int[] ans;
    int ansSize;

    public int[] topKFrequent(int[] nums, int k) {
        ansSize = 0;
        ans = new int[k];

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        ArrayList<int[]> list = new ArrayList<>();

        for (Entry<Integer, Integer> entry : map.entrySet()) {
            list.add(new int[]{entry.getKey(), entry.getValue()});
        }
        qsort(list, 0, list.size() - 1, k);

        return ans;
    }

    private void qsort(ArrayList<int[]> list, int start, int end, int k) {
        int pickedIndex = new Random().nextInt(end - start + 1) + start;
        int pickedVal = list.get(pickedIndex)[1];
        int index = start;
        for (int i = start; i <= end; i++) {
            if (list.get(i)[1] >= pickedVal) {
                Collections.swap(list, i, index++);
            }
        }

        if (k == index - start) {
            for (int i = start; i < index; i++) {
                ans[ansSize++] = list.get(i)[0];
            }
        } else if (k < index - start) {
            qsort(list, start, index - 1, k);
        } else {
            for (int i = start; i < index; i++) {
                ans[ansSize++] = list.get(i)[0];
            }
            qsort(list, index, end, k - (index - start));
        }
    }

    public static void main(String[] args) {
        new Solution().topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
    }
}