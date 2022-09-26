import java.util.Arrays;

public class QuickSort3 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 10, 9, 3, 5, 6, 7, 2, 2, 7, 8, 9};

        sort(nums);
        System.out.println(Arrays.toString(nums));
    }


    public static void sort(int[] nums) {
        // check input before operation;
        if (nums == null || nums.length == 0) {
            return;
        }

        quickSort(nums, 0, nums.length - 1);
    }

    private static void quickSort(int[] nums, int start, int end) {
        // set the recursion terminate condition;
        if (start >= end) {
            return;
        }

        // get the pivot position;
        int pivotPosition = partition(nums, start, end);
        quickSort(nums, start, pivotPosition - 1);
        quickSort(nums, pivotPosition + 1, end);
    }

    private static int partition(int[] nums, int start, int end) {
        //set the pivot position;
        int pivot = nums[end];
        while (start + 1 < end) {
            while (start < end && nums[start] <= pivot) {
                start ++;
            }
            if (nums[start] > pivot) {
                swap(nums, start, end);
            }

            while (start < end && nums[end] >= pivot) {
                end --;
            }
            if (nums[end] < pivot) {
                swap(nums, start, end);
            }
        }
        return end;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
