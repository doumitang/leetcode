class Solution33 {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int minValIndex = (getMaxValIndex(nums, 0, nums.length - 1) + 1) % nums.length;
        return recursion(nums, minValIndex, nums.length, target);
    }

    public int recursion(int[] nums, int low, int len, int target) {
//        System.out.println("" + low + " " + len);
//        if (low < 0 || low >= nums.length) return -1;
        if (len == 1) return target == nums[low] ? low : -1;
        int mid = ((low + low + len - 1) / 2) % nums.length;
        if (target == nums[mid]) {
            return mid;
        } else if (target < nums[mid]) {
            return recursion(nums, low, len / 2, target);
        } else {
            return recursion(nums, (low + len / 2) % nums.length, len - len / 2, target);
        }
    }

    public int getMaxValIndex(int[] nums, int low, int high) {
        int mid = (low + high) / 2;
        if (mid == low) return nums[low] > nums[high] ? low : high;
//        System.out.println("(" + nums[low] + ", " + nums[mid] + ", " + nums[high] + ")");
        if (nums[mid] < nums[low] && nums[mid] < nums[high]) {
            return getMaxValIndex(nums, low, mid - 1);
        } else {
            return getMaxValIndex(nums, mid, high);
        }
    }

    public static void main(String[] args) {
        Solution33 solution = new Solution33();
        int[] nums = new int[]{4,5,6,7,0,1,2};
        System.out.println(solution.search(nums, 3));
    }
}