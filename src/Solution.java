import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        ArrayList<AbstractMap.SimpleEntry<Integer, Integer>> list = new ArrayList<>();
        for (Integer key : map.keySet()) {
            list.add(new AbstractMap.SimpleEntry<>(key, map.get(key)));
        }

        PriorityQueue<AbstractMap.SimpleEntry<Integer, Integer>> queue = new PriorityQueue<>(
                (o1, o2) -> o2.getValue() - o1.getValue());

        queue.addAll(list);

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = queue.poll().getKey();
        }
        return ans;
    }
}