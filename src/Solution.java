import java.util.HashMap;

class Solution {

    HashMap<Character, int[]> map = new HashMap<>();

    public int leastInterval(char[] tasks, int n) {

        for (char task : tasks) {
            int[] taskEntry = map.getOrDefault(task, new int[2]);
            taskEntry[1]++;
            map.put(task, taskEntry);
        }

        int currentTime = 0;
        Character c;
        while ((c = getNextTask(currentTime)) != null) {
            int[] entry = map.get(c);
            if (entry[0] > currentTime) {
                currentTime = entry[0];
            }
            currentTime++;

            entry[0] = currentTime + n;
            if (entry[1] == 1) {
                map.remove(c);
            } else {
                entry[1] -= 1;
            }
        }
        return currentTime;
    }

    private Character getNextTask(int currentTime) {
        if (map.isEmpty()) {
            return null;
        }

        Character res = null;
        for (Character character : map.keySet()) {
            if (res == null) {
                res = character;
                continue;
            }
            int[] resEntry = map.get(res);
            int[] entry = map.get(character);

            if (entry[0] > currentTime && resEntry[0] <= currentTime) {
                continue;
            }

            if (entry[0] <= currentTime && resEntry[0] > currentTime) {
                res = character;
                continue;
            }

            if (entry[0] > currentTime && resEntry[0] > currentTime && entry[0] != resEntry[0]) {
                res = entry[0] < resEntry[0] ? character : res;
            }

            res = entry[1] > resEntry[1] ? character : res;
        }
        return res;
    }
}