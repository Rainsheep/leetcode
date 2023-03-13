import java.util.ArrayList;
import java.util.Arrays;

class Solution {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]);
        ArrayList<int[]> list = new ArrayList<>(Arrays.asList(people));

        for (int i = 0; i < list.size(); i++) {
            int t = list.get(i)[1];
            int j = 0;
            for (; j < i && t > 0; j++) {
                if (list.get(j)[0] >= list.get(i)[0]) {
                    t--;
                }
            }

            while (j < i && list.get(i)[0] > list.get(j)[0]) {
                j++;
            }
            if (i != j) {
                int[] remove = list.remove(i);
                list.add(j, remove);
            }
        }

        int[][] ans = new int[list.size()][2];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}