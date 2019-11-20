public class Solution38 {
    /**
     * 迭代 + StringBuilder
     * Runtime: 1 ms, faster than 99.42% of Java online submissions for Count and Say.
     * Memory Usage: 34.3 MB, less than 100.00% of Java online submissions for Count and Say.
     * @param n
     * @return
     */
    public String countAndSay(int n) {
        if (n == 1) return "1";
        String temp = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder ans = new StringBuilder();
            char pre = '0';
            int count = 0;
            for (int j = 0; j < temp.length(); j++) {
                char ch = temp.charAt(j);
                if (ch != pre) {
                    if (count > 0) {
                        ans.append(count);
                        ans.append(pre);
                    }
                    pre = ch;
                    count = 1;
                } else {
                    count++;
                }
            }
            ans.append(count);
            ans.append(pre);
            ans.insert(0, '1');
            StringBuffer sb = new StringBuffer();
            sb.append(pre);
            sb.insert(0, '1');
            temp = ans.toString();
        }
        return temp;
    }

    public static void main(String[] args) {
        Solution38 solution38 = new Solution38();
        solution38.countAndSay(4);
    }
}
