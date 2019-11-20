import java.util.LinkedList;
import java.util.List;

class MinStack {

    private List<Integer> stack;
    private int min;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new LinkedList<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        stack.add(x);
        min = Math.min(min, x);
    }

    public void pop() {
        if (stack.remove(stack.size() - 1) == min) {
            min = Integer.MAX_VALUE;
            for (int i:stack) {
                min = Math.min(min, i);
            }
        }
    }

    public int top() {
        return stack.get(stack.size() - 1);
    }

    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */