public class Solution27_2 {
    /**
     * 适合有比较少想要删除的数的情况
     * 用数组后面的数覆盖掉当前不想要的数
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Element.
     * Memory Usage: 36.1 MB, less than 100.00% of Java online submissions for Remove Element.
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        if (nums == null) return 0;
        int len = nums.length;
        if (len == 0) return 0;
        int i = 0, j = len - 1;
        while (i <= j) {
            if (nums[i] != val) {
                i++;
            } else {
                nums[i] = nums[j--];
            }
        }
        return i;
    }
}
