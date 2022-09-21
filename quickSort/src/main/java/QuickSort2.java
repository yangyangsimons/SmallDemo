import java.util.Arrays;

public class QuickSort2 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 10, 9, 3, 5, 6, 7, 2, 2, 7, 8, 9};

        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void sort(int[] nums) {
        // check input before operation;
        if (nums == null || nums.length == 0) {
            return;
        }
        quickSort(nums, 0, nums.length - 1);
    }

    private static void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivotPosition = division(nums, start, end);
        quickSort(nums, start, pivotPosition - 1);
        quickSort(nums, pivotPosition + 1, end);
    }

    private static int division(int[] nums, int start, int end) {
        int pivot = nums[start];
        while (start < end) {
            while (start < end && nums[end] >= pivot) {
                end--;
            }
            if (nums[end] < pivot) {
                swap(nums, end, start);
            }

            while (start < end && nums[start] <= pivot) {
                start ++;
            }
            if (nums[start] > pivot) {
                swap(nums, start, end);
            }
        }
        return start;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
