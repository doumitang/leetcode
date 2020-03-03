import java.util.*;

public class Solution406 {
    /**
     * 排序插入重建，关键在于按照(h, k)中的 h 和 k 排序确定插入的顺序
     * Runtime: 5 ms, faster than 98.84% of Java online submissions for Queue Reconstruction by Height.
     * Memory Usage: 42.5 MB, less than 91.49% of Java online submissions for Queue Reconstruction by Height.
     * @param people
     * @return
     */
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0 || people[0].length == 0) return new int[][]{};
        List<int[]> list = new ArrayList<>();
        for (int[] person : people) {
            list.add(person);
        }
        // 按照(h, k)中的 h 和 k 排序
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? Integer.compare(o2[0], o1[0]) : Integer.compare(o1[1], o2[1]);
            }
        });
        // 按照排序的顺序插入
        List<int[]> ans = new ArrayList<>();
        for (int[] ele : list) {
            ans.add(ele[1], ele);
        }
        return ans.toArray(people);
    }

    public static void main(String[] args) {
        Solution406 solution406 = new Solution406();
        int[][] people = {
                {7,0},{4,4},{7,1},{5,0},{6,1},{5,2}
        };
        System.out.println(solution406.reconstructQueue(people));
    }
}
