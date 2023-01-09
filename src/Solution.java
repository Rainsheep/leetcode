import java.util.Arrays;

class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] num = Arrays.copyOfRange(nums1, 0, m);
        int p1 = 0;
        int p2 = 0;

        for (int i = 0; i < m + n; i++) {
            if (p1 < m && p2 < n) {
                if (num[p1] <= nums2[p2]) {
                    nums1[i] = num[p1++];
                } else {
                    nums1[i] = nums2[p2++];
                }
                continue;
            }

            if (p1 < m) {
                nums1[i] = num[p1++];
            } else {
                nums1[i] = nums2[p2++];
            }

        }

    }

}