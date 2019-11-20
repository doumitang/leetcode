import java.util.Arrays;

class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        int tempIndex = recursion(nums,0 ,nums.length - 1, target);
        if (tempIndex < 0) {
            return ans;
        }
        int i = tempIndex, j = tempIndex;
        while (i - 1 >= 0 && nums[i - 1] == target) {
            i--;
        }
        while (j + 1 < nums.length && nums[j + 1] == target) {
            j++;
        }
        ans[0] = i;
        ans[1] = j;
        return ans;
    }

    public int recursion(int[] nums, int low, int high, int target) {
        if (low > high) return -1;
        int mid = (low + high) / 2;
        if (target == nums[mid]) {
            return mid;
        } else if (target < nums[mid]) {
            return recursion(nums, low, mid - 1, target);
        } else {
            return recursion(nums, mid + 1, high, target);
        }
    }

    public static void main(String[] args) {
        Solution34 solution34 = new Solution34();
        int[] nums = {2, 2};
        System.out.println(Arrays.toString(solution34.searchRange(nums, 1)));
    }
}