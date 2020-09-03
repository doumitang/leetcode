import java.util.Stack;

public class Solution739_3 {
    /**
     * 每日温度，经典单调栈，基础一定要掌握
     * 正向遍历
     * 时间 O(n)，空间 O(n)
     * @param T
     * @return
     */
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>(); // 存的是索引
        int[] ans = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                int index = stack.pop();
                ans[index] = i - index;
            }
            stack.push(i);
        }
        return ans;
    }
}
