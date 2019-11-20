import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution32 {
    // O(n^2)，超时了！！！
    public int longestValidParentheses(String s) {
        int ans = 0;
        int[][] status = new int[s.length()][s.length()+1];
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                if (isValid(s, i, j, status)) {
                    String sub = s.substring(i, j);
                    ans = sub.length() > ans ? sub.length() : ans;
                }
            }
        }
//        for (int[] dp : status) {
//            System.out.println(Arrays.toString(dp));
//        }
        return ans;
    }

    public boolean isValid(String s, int i, int j, int[][] status) {
        if (status[i][j] == 2) return true;
        if (status[i][j] == 1) return false;
        int len = j - i;
        if (len < 2 || len % 2 == 1) {
            status[i][j] = 1;
            return false;
        }
        if (len == 2 && s.substring(i, j).equals("()")) {
            status[i][j] = 2;
            return true;
        }
        // 嵌套
        boolean f1 = isValid(s, i + 1, j - 1, status) && s.charAt(i) == '(' && s.charAt(j - 1) == ')';
        if (f1) {
            status[i][j] = 2;
            return true;
        }
        // 连接
        List<Integer> indexList = new ArrayList<Integer>();
        for (int k = i; k <= j - 2; k++) {
//            System.out.println("(" + i + ", " + j + ")");
            if (s.charAt(k) == ')' && s.charAt(k + 1) == '(') {
                indexList.add(k + 1);
            }
        }
        for (int index : indexList) {
            boolean temp = isValid(s, i, index, status) && isValid(s, index, j, status);
            if (temp) {
                status[i][j] = 2;
                return true;
            }
        }
        status[i][j] = 1;
        return false;
    }

    public static void main(String[] args) {
        Solution32 solution = new Solution32();
        System.out.println(solution.longestValidParentheses("((())())(()))(()()(()(()))(()((((()))))))((()())()))()()(()(((((()()()())))()())(()()))((((((())))((()))()()))))(()))())))()))()())((()()))))(()(((((())))))()((()(()(())((((())(())((()()(()())))())(()(())()()))())(()()()))()(((()())(((()()())))(((()()()))(()()))()))()))))))())()()((()(())(()))()((()()()((())))()(((()())(()))())())))(((()))))())))()(())))()())))())()((()))((()))()))(((())((()()()(()((()((())))((()()))())(()()(()))))())((())))(()))()))))))()(()))())(()())))))(()))((())(()((())(((((()()()(()()())))(()())()((()(()()))(()(())((()((()))))))))(()(())()())()(()(()(()))()()()(()()())))(())(()((((()()))())))(())((()(())())))))())()()))(((())))())((()(()))(()()))((())(())))))(()(()((()((()()))))))(()()()(()()()(()(())()))()))(((()(())()())(()))())))(((()))())(()((()))(()((()()()(())()(()())()(())(()(()((((())()))(((()()(((()())(()()()(())()())())(()(()()((()))))()(()))))(((())))()()))(()))((()))))()()))))((((()(())()()()((()))((()))())())(()((()()())))))))()))(((()))))))(()())))(((()))((()))())))(((()(((())))())(()))))(((()(((((((((((((())(((()))((((())())()))())((((())(((())))())(((()))))()())()(())())(()))))()))()()()))(((((())()()((()))())(()))()()(()()))(())(()()))()))))(((())))))((()()(()()()()((())((((())())))))((((((()((()((())())(()((()))(()())())())(()(())(())(()((())((())))(())())))(()()())((((()))))((()(())(()(()())))))))))((()())()()))((()(((()((()))(((((()()()()()(()(()((()(()))(()(()((()()))))()(()()((((((()((()())()))((())()()(((((()(()))))()()((()())((()())()(())((()))()()(()))"));
    }
}