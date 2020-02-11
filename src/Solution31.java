import java.util.Arrays;

public class Solution31 {
    /**
     * 关键在于找出最长逆序后缀的前一个数字，然后在后缀中找出刚好大于这个数字的数与之进行交换，最后把后缀反转
     * 时间 o(n)，空间 O(1)
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Next Permutation.
     * Memory Usage: 39.5 MB, less than 50.00% of Java online submissions for Next Permutation.
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        int len = nums.length, index = len - 2;
        // 找到最长逆序后缀的前一个数字位置 index
        while (index >= 0 && nums[index] >= nums[index + 1]) {
            index--;
        }
        if (index >= 0) {
            // 找到最长逆序后缀中刚好大于 位于 index 的数字的位置
            int pos = len - 1;
            while (nums[pos] <= nums[index]) {
                pos--;
            }
            swap(nums, index, pos);
        }
        reverse(nums, index + 1);
    }

    private void reverse(int[] nums, int start) {
        int end = nums.length - 1;
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Solution31 solution31 = new Solution31();
        int[] nums = {1, 2, 3};
        solution31.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
