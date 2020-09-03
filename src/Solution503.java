import java.util.Arrays;
import java.util.Stack;

public class Solution503 {
    /**
     * 循环数组找下一个更大元素，遍历两遍数组即可（注意索引的取余）
     * 时间 O(n)，空间 O(n)
     * @param nums
     * @return
     */
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>(); // 存的是索引
        int[] ans = new int[nums.length];
        Arrays.fill(ans, -1);
        for (int i = 0; i < 2 * nums.length; i++) {
            while (!stack.isEmpty() && nums[i % nums.length] > nums[stack.peek()]) {
                ans[stack.pop()] = nums[i % nums.length];
            }
            stack.push(i % nums.length);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution503 solution503 = new Solution503();
        System.out.println(Arrays.toString(solution503.nextGreaterElements(new int[]{1, 2, 1})));
    }
}
