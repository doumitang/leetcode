public class Solution38_2 {
    /**
     * StringBuilder类
     * Runtime: 2 ms, faster than 62.02% of Java online submissions for Count and Say.
     * Memory Usage: 34.2 MB, less than 100.00% of Java online submissions for Count and Say.
     * @param n
     * @return
     */
    public String countAndSay(int n) {
        if (n == 1) return "1";
        String temp = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder ans = new StringBuilder();
            int k;
            for (int j = 0; j < temp.length(); j = k) {
                k = j;
                while (k < temp.length() && temp.charAt(k) == temp.charAt(j)) k++;
                ans.append(k - j).append(temp.charAt(j));
            }
            temp = ans.toString();
        }
        return temp;
    }

    public static void main(String[] args) {
        Solution38_2 solution38_2 = new Solution38_2();
        solution38_2.countAndSay(4);
    }
}
