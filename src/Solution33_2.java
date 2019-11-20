class Solution33_2 {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        return getTargetIndex(nums, 0, nums.length - 1, target);
    }

    public int getTargetIndex(int[] nums, int low, int high, int target) {
        if (low == high) return nums[low] == target ? low : -1;
        if (low + 1 == high) {
            if (nums[low] == target) return low;
            if (nums[high] == target) return high;
            return -1;
        }
        int mid = (low + high) / 2;
        System.out.println("(" + nums[low] + ", " + nums[mid] + ", " + nums[high] + ")");
        // 分界在左边，则右边顺序正常
        if (nums[mid] < nums[low] && nums[mid] < nums[high]) {
            if (target >= nums[mid] && target <= nums[high]) {
                return getTargetIndex(nums, mid, high, target);
            } else {
                return getTargetIndex(nums, low, mid - 1, target);
            }
            // 分界在右边，则左边顺序正常
        } else {
            if (target >= nums[low] && target < nums[mid]) {
                return getTargetIndex(nums, low, mid - 1, target);
            } else {
                return getTargetIndex(nums, mid, high, target);
            }
        }
    }

    public static void main(String[] args) {
        Solution33_2 solution = new Solution33_2();
        int[] nums = new int[]{1,3};
        System.out.println(solution.search(nums, 0));
    }
}