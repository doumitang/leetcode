public class Solution11_2 {
    /**
     * 双指针法，时间O(n)
     * area = (j - i) * min(height[i], height[j]) = A * B
     * 如果增加A，那么移动大的一端和小的一端都有可能使得结果更好，但是
     * 如果减少A，只有移动小的一端才有可能使得结果更好，所以
     * 以A的最大值为初始状态
     * 太秀了
     *
     * Runtime: 2 ms, faster than 95.34% of Java online submissions for Container With Most Water.
     * Memory Usage: 40.1 MB, less than 93.59% of Java online submissions for Container With Most Water.
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int ans = 0, len = height.length;
        int i = 0, j = len - 1;
        while (i < j) {
            ans = Math.max(ans, (j - i) * Math.min(height[i], height[j]));
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return ans;
    }
}
