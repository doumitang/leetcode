import java.util.Arrays;

public class Solution4 {
    /**
     * 归并排序的合并，时间O(m + n)，空间O(m + n)
     * Runtime: 2 ms, faster than 99.97% of Java online submissions for Median of Two Sorted Arrays.
     * Memory Usage: 47 MB, less than 87.50% of Java online submissions for Median of Two Sorted Arrays.
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int len = len1 + len2;
        int[] temp = new int[len];
        int i = 0, j = 0, k = 0;
        while (i < len1 && j < len2) {
            if (nums1[i] < nums2[j]) {
                temp[k++] = nums1[i++];
            } else {
                temp[k++] = nums2[j++];
            }
        }
        while (i < len1) {
            temp[k++] = nums1[i++];
        }
        while (j < len2) {
            temp[k++] = nums2[j++];
        }
        return len % 2 == 1 ? temp[len / 2] : (temp[len / 2] + temp[len / 2 - 1]) / 2.0;
    }

    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.println(solution4.findMedianSortedArrays(nums1, nums2));
    }
}
