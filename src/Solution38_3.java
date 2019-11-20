public class Solution38_3 {
    /**
     * 递归 + StringBuilder
     * Runtime: 1 ms, faster than 99.42% of Java online submissions for Count and Say.
     * Memory Usage: 34.3 MB, less than 100.00% of Java online submissions for Count and Say.
     * @param n
     * @return
     */
    public String countAndSay(int n) {
        if (n == 1) return "1";
        String temp = countAndSay(n - 1);
        StringBuilder ans = new StringBuilder();
        int k;
        for (int j = 0; j < temp.length(); j = k) {
            k = j;
            while (k < temp.length() && temp.charAt(k) == temp.charAt(j)) k++;
            ans.append(k - j).append(temp.charAt(j));
        }
        return ans.toString();
    }
}
