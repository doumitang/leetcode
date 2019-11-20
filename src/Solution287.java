import java.util.HashSet;
import java.util.Set;

public class Solution287 {
    public int findDuplicate(int[] nums) {
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (set.contains(i)) {
                ans = i;
                break;
            }
            set.add(i);
        }
        return ans;
    }
}
