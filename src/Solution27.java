public class Solution27 {
    /**
     * 双指针法
     * 适合有很多想要删除的数的情况
     * 对于nums = [4,1,2,3,5], val = 4nums=[4,1,2,3,5],val=4的情况，有点浪费赋值操作
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
        int i = 0, j = 0;
        while (i < len && j <len) {
            if (nums[j] != val) {
                nums[i++] = nums[j++];
            } else {
                j++;
            }
        }
        return i;
    }
}
