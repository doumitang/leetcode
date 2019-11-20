import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution207 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] array:prerequisites) {
            int pre = array[1], post = array[0];
            graph[pre].add(post);
        }
        // -1代表还没被访问，0代表正在被访问，1代表访问结束
        int[] status = new int[numCourses];
        Arrays.fill(status, -1);
        for (int i = 0; i < graph.length; i++) {
            status[i] = 0;
            if (DFS(graph, status, i)) return false;
            status[i] = 1;
        }
        return true;
    }

    private boolean DFS(List<Integer>[] graph, int[] status, int index) {
        for (int vertex:graph[index]) {
            if (status[vertex] == 0) return true;
            if (status[vertex] == 1) continue;
            status[vertex] = 0;
            if (DFS(graph, status, vertex)) return true;
            status[vertex] = 1;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution207 solution207 = new Solution207();
        int[][] prerequisites = {{1, 0}};
        int[][] prerequisites1 = {{0, 2}, {1, 2}, {2, 0}};
        System.out.println(solution207.canFinish(2, prerequisites));
    }
}
