public class Solution394 {

    private int index = 0;

    public String decodeString(String s) {
        char[] str = s.toCharArray();
        return decodeStringCore(str);
    }

    /**
     * 递归子括号里的内容，关键在于用全局变量 index 实时更新处理子问题时遍历到的下标
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Decode String.
     * Memory Usage: 39 MB, less than 5.68% of Java online submissions for Decode String.
     */
    private String decodeStringCore(char[] str) {
        StringBuilder ret = new StringBuilder();
        while (index < str.length) {
            if (str[index] == ']') {
                index++;
                return ret.toString();
            } else if (!isDigit(str[index])) {
                ret.append(str[index++]);
                continue;
            }
            int num = 0;
            while (isDigit(str[index])) {
                num = num * 10 + (str[index++] - '0');
            }
            index++;
            String sub = decodeStringCore(str);
            for (int i = 0; i < num; i++) {
                ret.append(sub);
            }
        }
        return ret.toString();
    }

    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    public static void main(String[] args) {
        Solution394 solution394 = new Solution394();
        System.out.println(solution394.decodeString(

                "3[2[bc]]"));
    }

    /*
3[
    z
 ]
2[
    2[
        y
    ]
    pq
    4[
        2[
            jk
         ]
         e
         1[
                f
         ]
    ]
]
ef
     */
    /*
    "zzzyypqjkjkefjkjkefjkjkefjkjkefefyypqjkjkefjkjkefjkjkefjkjkefef"
    "zzzyypqjkjkefjkjkefjkjkefjkjkefyypqjkjkefjkjkefjkjkefjkjkefef"
     */
}
