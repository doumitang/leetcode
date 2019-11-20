class Solution42 {
    public int trap(int[] height) {
        int ans = 0, heightIndex = 0;
        if (height.length < 3) return ans;
        int p = 0, q = 0;
        while (p < height.length && height[p] == 0) {
            p++;
        }
        if (p == height.length) return ans;
        do {
            q = p + 1;
            while (q < height.length && height[q] == 0) {
                q++;
            }
            if (q == height.length) return ans;
            // 短板效应
            heightIndex = height[p] <= height[q] ? p : q;
            System.out.println("" + p + " " + q + " " + height[heightIndex]);
            for (int i = p+1; i <= q-1; i++) {
                int delta = height[heightIndex] - height[i];
                ans += delta;
            }
            p = q;
        } while (true);
    }

    public static void main(String[] args) {
        Solution42 solution42 = new Solution42();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(solution42.trap(height));
    }
}