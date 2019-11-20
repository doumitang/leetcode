public class Solution75_3 {
    // 天秀的算法
    public void sortColors(int[] nums) {
        int i = -1, j = -1, k = -1;
        for (int p = 0; p < nums.length; p++) {
            if (nums[p] == 0) {
                nums[++k] = 2;
                nums[++j] = 1;
                nums[++i] = 0;
            } else if (nums[p] == 1) {
                nums[++k] = 2;
                nums[++j] = 1;
            } else {
                nums[++k] = 2;
            }
            // System.out.println(Arrays.toString(nums));
        }
    }
}
