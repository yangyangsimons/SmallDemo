import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums = new int[]{10, 2, 3, 4, 6, 7, 8, 4, 2, 8, 5, 3, 1, 0};

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
        // select the last element as the pivot;
        int pivot = nums[end];
        int j = start - 1;
        for (int i = start; i < end; i++) {
            if (nums[i] <= pivot) {
                j++;
                if (j != i) {
                    swamp(nums, j, i);
                }
            }
        }
        swamp(nums, j + 1, end);
        return j + 1;
    }

    private static void swamp(int[] nums, int j, int i) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
