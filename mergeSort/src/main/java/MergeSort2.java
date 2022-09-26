import java.util.Arrays;

public class MergeSort2 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 10, 9, 5, 6, 3, 2, 7, 5, 8, 1, 8};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sort(int[] nums) {
        // check input before operation;
        if (nums == null || nums.length == 0) {
            return;
        }

        int[] temp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1, temp);
    }

    private static void mergeSort(int[] nums, int start, int end, int[] temp) {
        // set the recursion terminate condition;
        if (start >= end) {
            return;
        }

        int mid = start + (end - start) / 2;

        mergeSort(nums, start, mid, temp);
        mergeSort(nums, mid + 1, end, temp);
        merge(nums, start, mid, end, temp);
    }

    private static void merge(int[] nums, int start, int mid, int end, int[] temp) {

        int left = start;
        int right = mid + 1;
        int index = start;
        while (left <= mid && right <= end) {
            if (nums[left] < nums[right]) {
                temp[index] = nums[left];
                left++;
            } else {
                temp[index] = nums[right];
                right++;
            }
            index++;
        }

        while (left <= mid) {
            temp[index++] = nums[left++];
        }

        while (right <= end) {
            temp[index++] = nums[right++];
        }

        for (index = start; index <= end; index++) {
            nums[index] = temp[index];
        }
    }
}
