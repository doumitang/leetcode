public class Solution12 {
    /**
     * Runtime: 3 ms, faster than 100.00% of Java online submissions for Integer to Roman.
     * Memory Usage: 36.4 MB, less than 100.00% of Java online submissions for Integer to Roman.
     * @param num
     * @return
     */
    public String intToRoman(int num) {
        int[] val = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] str = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};

        StringBuilder ans = new StringBuilder();
        int index = val.length - 1;
        while (num > 0) {
            if (num / val[index] > 0) {
                ans.append(str[index]);
                num -= val[index];
            } else {
                index--;
            }
        }
        return ans.toString();
    }
}
