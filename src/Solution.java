import java.util.Arrays;

class Solution {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o2[1] - o1[1]);
        int[][] ans = new int[people.length][];
        for (int[] person : people) {
            int space = person[1] + 1;
            for (int j = 0; j < people.length; ++j) {
                if (ans[j] == null) {
                    --space;
                    if (space == 0) {
                        ans[j] = person;
                        break;
                    }
                }

            }

        }

        return ans;
    }
}