public class Solution42_2 {
    /**
     * 双指针的官方题解不是很理解，就看了评论的一个大佬的题解
     *
     * left_max：左边的最大值，它是从左往右遍历找到的
     * right_max：右边的最大值，它是从右往左遍历找到的
     * left：从左往右处理的当前下标
     * right：从右往左处理的当前下标
     *
     * 定理一：在某个位置i处，它能存的水，取决于它左右两边的最大值中较小的一个。
     *
     * 定理二：当我们从左往右处理到left下标时，左边的最大值left_max对它而言是可信的，但right_max对它而言是不可信的。（见下图，由于中间状况未知，对于left下标而言，right_max未必就是它右边最大的值）
     *
     * 定理三：当我们从右往左处理到right下标时，右边的最大值right_max对它而言是可信的，但left_max对它而言是不可信的。
     *
     *                                    right_max
     *  left_max                             __
     *    __                                |  |
     *   |  |__   __??????????????????????  |  |
     * __|     |__|                       __|  |__
     *         left                      right
     *
     * 对于位置left而言，它左边最大值一定是left_max，右边最大值“大于等于”right_max，
     * 这时候，如果left_max < right_max成立，那么它就知道自己能存多少水了，无论右边将来会不会出现更大的right_max，都不影响这个结果。
     * 所以当left_max < right_max时，我们就希望去处理left下标，反之，我们希望去处理right下标。
     *
     * 时间 O(n)，空间 O(1)
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int left = 0, leftMax = 0;
        int right = height.length - 1, rightMax = 0;
        int ans = 0;
        while (left <= right) {
            if (leftMax < rightMax) {
                ans += Math.max(leftMax - height[left], 0);
                leftMax = Math.max(leftMax, height[left]);
                left++;
            } else {
                ans += Math.max(rightMax - height[right], 0);
                rightMax = Math.max(rightMax, height[right]);
                right--;
            }
        }
        return ans;
    }
}
