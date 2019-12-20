import com.sun.deploy.net.offline.WIExplorerOfflineHandler;

public class Solution28 {
    /**
     * 自己实现KMP算法
     * Runtime: 1 ms, faster than 66.60% of Java online submissions for Implement strStr().
     * Memory Usage: 36.1 MB, less than 100.00% of Java online submissions for Implement strStr().
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        if (haystack.length() < needle.length()) return -1;
        char[] t = haystack.toCharArray();
        char[] p = needle.toCharArray();
        int m = t.length, n = p.length;
        int i = 0, j = 0;
        int[] next = getNext(p);
        while (i < m && j < n) {
            if (j == -1 || t[i] == p[j]) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j == n) return i - n;
        else return -1;
    }

    public int[] getNext(char[] p) {
        int len = p.length;
        int[] next = new int[len];
        next[0] = -1;
        int j = 0, k = -1;
        while (j < len - 1) {
            if (k == -1 || p[j] == p[k]) {
                // 优化的next数组
                if (p[++j] == p[++k]) {
                    next[j] = next[k];
                } else {
                    next[j] = k;
                }
            } else {
                k = next[k];
            }
        }
        return next;
    }
}
