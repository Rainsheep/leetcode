import java.util.HashMap;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int maxCount = 0;
        int someCount = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (char task : tasks) {
            int count = map.getOrDefault(task, 0) + 1;
            map.put(task, count);

            if (count > maxCount) {
                maxCount = count;
                someCount = 1;
            } else if (count == maxCount) {
                someCount++;
            }


        }
        
        int res = maxCount * (n + 1) - n + someCount - 1;
        return Math.max(tasks.length, res);
    }
}