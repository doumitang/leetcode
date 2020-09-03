import java.util.Stack;

class Solution42 {
    /**
     * 接雨水
     *
     * 直观想法：对于数组中的每个元素，我们找出下雨后水能达到的最高位置，等于两边最大高度的较小值减去当前高度的值。
     * 时间 O(n^2)，空间 O(1)
     *
     * 改进：用两个 dp 数组，分别向左和向右扫描一次找到最大值
     * 时间 O(n)，空间 O(n)
     *
     * 单调栈
     * 如果我们发现一个条形块长于栈顶，我们可以确定栈顶的条形块被当前条形块和栈的前一个条形块界定，因此我们可以弹出栈顶元素并且累加答案到 ans
     * 时间 O(n)，空间 O(n)
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int index = stack.pop();
                if (stack.isEmpty()) break;
                int distance = i - stack.peek() - 1;
                int boundHeight = Math.min(height[i], height[stack.peek()]) - height[index];
                ans += distance * boundHeight;
            }
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution42 solution42 = new Solution42();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(solution42.trap(height));
    }
}