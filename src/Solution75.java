public class Solution75 {
    // 常数空间，但是遍历了两遍
    public void sortColors(int[] nums) {
        int i = 0, j = 0;
        for (int val : nums) {
            if (val == 0) i++;
            if (val == 1) j++;
        }
        for (int index = 0; index < i; index++) {
            nums[index] = 0;
        }
        for (int index = i; index < i + j; index++) {
            nums[index] = 1;
        }
        for (int index = i + j; index < nums.length; index++) {
            nums[index] = 2;
        }
    }
}
