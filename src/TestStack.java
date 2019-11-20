import java.util.Collections;
import java.util.Stack;

public class TestStack {
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<Character>();
        System.out.println(stack);
        stack.push('(');
        System.out.println(stack);
        stack.push(')');
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
    }
}
