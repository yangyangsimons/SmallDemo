import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums = new int[]{10, 2, 3, 4, 6, 7, 8, 4, 2, 8, 5, 3, 1, 0};

        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sort(int[] nums){
        // check input before operation;
        if (nums == null || nums.length == 0) {
            return;
        }

        quickSort(nums, 0, nums.length - 1);
    }

    private static void quickSort(int[] nums, int start, int end){
        // set the recursion terminate conditions;
        if (start >= end) {
            return;
        }

        //get the pivot element position;
        int pivotPosition = partition(nums, start, end);
        quickSort(nums, start, pivotPosition - 1);
        quickSort(nums, pivotPosition + 1, end);
    }

    private static int partition(int[] nums, int start, int end){
        int pivot = nums[end];
        int j = start - 1;

        // traverse the whole array;
        for (int i = start; i < end; i ++) {
            // move the j pointer if there the value is less or equal to the pivot;
            if (nums[i] <= pivot) {
                j ++;
                // if i is not euqal to j which means there is element's greater than pivot;
                if (i != j) {
                    swap(nums, i, j);
                }
            }

        }
        swap(nums, j + 1, end);
        return j + 1;
    }

    private static void swap(int[] nums, int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
