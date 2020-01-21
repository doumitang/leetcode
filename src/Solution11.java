public class Solution11 {
    /**
     * 暴力法，时间O(n^2)
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int ans = 0, len = height.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                ans = Math.max(ans, (j - i) * Math.min(height[i], height[j]));
            }
        }
        return ans;
    }
}
