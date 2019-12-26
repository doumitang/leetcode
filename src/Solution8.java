public class Solution8 {
    /**
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for String to Integer (atoi).
     * Memory Usage: 35.9 MB, less than 100.00% of Java online submissions for String to Integer (atoi).
     * @param str
     * @return
     */
    public int myAtoi(String str) {
        char[] array = str.toCharArray();
        int len = array.length;
        if (len == 0) return 0;
        int start = 0;
        while (start < len && array[start] == ' ') {
            start++;
        }
        if (start == len) return 0;
        boolean isPositive = true;
        int ans = 0;
        if (array[start] == '+') {
            start++;
        } else if (array[start] == '-') {
            start++;
            isPositive = false;
        } else if (array[start] > '9' || array[start] < '0') {
            return 0;
        }
        int end = start;
        while (end < len && array[end] <= '9' && array[end] >= '0') {
            int temp = isPositive ? array[end] - '0' : -(array[end] - '0');
            if (isPositive && ans > (Integer.MAX_VALUE - temp) / 10) return Integer.MAX_VALUE;
            if (!isPositive && ans < (Integer.MIN_VALUE - temp) / 10) return Integer.MIN_VALUE;
            ans = ans * 10 + temp;
            end++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution8 solution8 = new Solution8();
        System.out.println(solution8.myAtoi("  -42"));
    }
}
