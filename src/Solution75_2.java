import java.util.Arrays;

public class Solution75_2 {
    // 2+1个指针
    public void sortColors(int[] nums) {
        int red = 0, blue = nums.length - 1;
        int i = 0;
        while (i <= blue) {
            System.out.println("" + red + " " + i + " " + blue);
            if (nums[i] == 0) {
                swap(nums, i, red);
                red++;
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                swap(nums, i, blue);
                blue--;
            }
            System.out.println(Arrays.toString(nums));
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Solution75_2 solution75_2 = new Solution75_2();
        int[] nums = {2,0,1};
        solution75_2.sortColors(nums);
    }
}
