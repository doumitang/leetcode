import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution496 {
    /**
     * 单调栈
     * 不知道 nums1 中的元素在 nums2 中的具体位置，所以就用 map 存 num -> ans 的映射
     * 时间 O(m + n)，空间 O(n)
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>(); // 存的是数字
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[nums1.length];

        for (int num : nums2) {
            while (!stack.isEmpty() && num > stack.peek()) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }
        while (!stack.isEmpty()) {
            map.put(stack.pop(), -1);
        }

        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.get(nums1[i]);
        }
        return ans;
    }
}
