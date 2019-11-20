import java.util.Arrays;

class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        int[] index = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            index[i] = i;
        }
        sort(nums, 0, nums.length - 1, index);
        int i = 0, j = nums.length - 1;
        while (i < j) {
            if (nums[i] + nums[j] == target) {
                ans[0] = index[i];
                ans[1] = index[j];
                break;
            } else if (nums[i] + nums[j] < target) {
                i++;
            } else if (nums[i] + nums[j] > target) {
                j--;
            }
        }
        return ans;
    }

    public void sort(int[] nums, int low, int high, int index[]) {
        int start = low;
        int end = high;
        int key = nums[low];


        while (end > start) {
            //从后往前比较
            while (end > start && nums[end] >= key)  //如果没有比关键值小的，比较下一个，直到有比关键值小的交换位置，然后又从前往后比较
                end--;
            if (nums[end] <= key) {
                // 交换值
                int temp = nums[end];
                nums[end] = nums[start];
                nums[start] = temp;
                // 更新索引数组
                temp = index[end];
                index[end] = index[start];
                index[start] = temp;
            }
            //从前往后比较
            while (end > start && nums[start] <= key)//如果没有比关键值大的，比较下一个，直到有比关键值大的交换位置
                start++;
            if (nums[start] >= key) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                // 更新索引数组
                temp = index[end];
                index[end] = index[start];
                index[start] = temp;
            }
            //此时第一次循环比较结束，关键值的位置已经确定了。左边的值都比关键值小，右边的值都比关键值大，但是两边的顺序还有可能是不一样的，进行下面的递归调用
        }
        //递归
        if (start > low) sort(nums, low, start - 1, index);//左边序列。第一个索引位置到关键值索引-1
        if (end < high) sort(nums, end + 1, high, index);//右边序列。从关键值索引+1到最后一个
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int[] nums = {3, 1, 2};
        System.out.println(Arrays.toString(solution1.twoSum(nums, 5)));
    }
}
