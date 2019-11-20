class Solution215 {
    // 快排
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) return Integer.MAX_VALUE;
        return recursion(nums, 0, nums.length - 1, k - 1);
    }

    private int recursion(int[] nums, int left, int right, int k) {
        if (left == right) return nums[left];
        int[] pos = partition(nums, left, right, nums[left + (int) (Math.random() * (right - left + 1))]);
        if (k < pos[0]) {
            // k处于大于区域
            return recursion(nums, left, pos[0] - 1, k);
        } else if (k <= pos[1]) {
            // k处于小于区域
            return nums[k];
        } else {
            // k处于相等区域（k为绝对位置）
            return recursion(nums, pos[1] + 1, right, k);
        }
    }

    private int[] partition(int[] nums, int left, int right, int num) {
        int pGreater = left - 1, pLess = right + 1, cur = left;
        while (cur < pLess) {
            if (nums[cur] < num) swap(nums, cur, --pLess);
            else if (nums[cur] > num) swap(nums, cur++, ++pGreater);
            else cur++;
        }
        return new int[]{pGreater + 1, pLess - 1};
    }

    private void swap(int[] array, int p1, int p2) {
        int temp = array[p1];
        array[p1] = array[p2];
        array[p2] = temp;
    }
}