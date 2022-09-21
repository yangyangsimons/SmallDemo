import java.util.Arrays;

public class MergeSort2 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 10, 9, 5, 6, 3, 2, 7, 5, 8, 1, 8};
        sort2(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void sort2(int[] nums) {
        // check input before operation;
        if (nums == null || nums.length == 0) {
            return;
        }
        // mergeSort method
        int[] temp = new int[nums.length];
        mergeSort(nums, temp, 0, nums.length - 1);
    }

    private static void mergeSort(int[] nums, int[] temp, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        mergeSort(nums, temp, start, mid);
        mergeSort(nums, temp, mid + 1, end);
        merge(nums, start, mid, end, temp);
    }

    private static void merge(int[] nums, int start, int mid, int end, int[] temp) {
        int left = start;
        int right = mid + 1;
        int index = start;

        while (left <= mid && right <= end) {
            if (nums[left] <= nums[right]) {
                temp[index++] = nums[left++];
            } else {
                // nums[left] > nums[right]
                temp[index++] = nums[right++];
            }
        }
        // if the number of element in left part and right part is not equal;
        while (left <= mid) {
            temp[index++] = nums[left++];
        }
        while (right <= end) {
            temp[index++] = nums[right++];
        }
        // copy temp to nums;
        for (index = start; index <= end; index++) {
            nums[index] = temp[index];
        }

    }
}
