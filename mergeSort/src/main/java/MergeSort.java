import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] nums = new int[]{10, 6, 4, 6, 3, 2, 6, 5, 7, 8, 9};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }


    public static void sort(int[] nums) {
        // check input before operation;
        if (nums == null || nums.length == 0) {
            return;
        }

        mergeSort(nums, 0, nums.length - 1);
    }

    private static void mergeSort(int[] nums, int start, int end) {
        // set the terminate condition of recursion;
        if (start >= end) {
            return;
        }

        int mid = start + (end - start) / 2;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);
        merge(nums, start, mid, end);

    }

    private static void merge(int[] nums, int start, int mid, int end) {
        // create left and right arrays to store the sorted result;

        int leftLen = mid - start + 1;
        int rightLen = end - mid;

        int[] left = new int[leftLen];
        int[] right = new int[rightLen];


        // copy the partial sorted array in left and right arrays;
        for (int i = 0; i < leftLen; i++) {
            left[i] = nums[i];
        }

        for (int i = 0; i < rightLen; i++) {
            right[i] = nums[mid + 1 + i];
        }


        int index = start;
        int i = 0;
        int j = 0;

        while (i < leftLen && j < rightLen) {
            if (left[i] < right[j]) {
                nums[index] = left[i];
                i++;
            } else {
                nums[index] = right[j];
                j++;
            }

            index++;
        }

        // if the left is longer
        while (i < leftLen) {
            nums[index++] = left[i++];
        }

        // if the right array is longer
        while (j < rightLen) {
            nums[index++] = right[j++];
        }
    }
}

