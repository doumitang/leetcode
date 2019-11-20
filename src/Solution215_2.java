public class Solution215_2 {
    // 最小堆 O(nlogk)
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) return Integer.MAX_VALUE;
        int[] heap = new int[k];
        for (int i = 0; i < k; i++) {
            insert(heap, nums[i], i);
        }
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > heap[0]) {
                heap[0] = nums[i];
                siftDown(heap, 0, k); // 从覆盖的位置开始调整
            }
        }
        return heap[0];
    }

    private void insert(int[] heap, int num, int i) {
        heap[i] = num;
        while (heap[i] < heap[(i - 1) / 2]) {
            swap(heap, i, (i - 1) / 2);
            i = (i - 1) / 2 ;
        }
    }

    private void siftDown(int[] heap, int i, int heapSize) {
        int child = 2 * i + 1;
        while (child < heapSize) {
            int lessIndex = child + 1 < heapSize && heap[child + 1] < heap[child] ? child + 1 : child;
            if (heap[i] <= heap[lessIndex]) break;
            swap(heap, i, lessIndex);
            i = lessIndex;
            child = 2 * i + 1;
        }
    }

    private void swap(int[] array, int p1, int p2) {
        int temp = array[p1];
        array[p1] = array[p2];
        array[p2] = temp;
    }
}
