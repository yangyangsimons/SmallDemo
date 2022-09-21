import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] nums = new int[] {10,6,4,6,3,2,6,5,7,8,9};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sort(int[] nums) {
        // check input before operation;
        if (nums == null || nums.length == 0){
            return;
        }
        mergeSort(nums, 0, nums.length - 1);
    }
    private static void mergeSort(int[] nums, int start, int end){
        if (start < end){
            int mid = start + (end - start) / 2;
            mergeSort(nums, start, mid);
            mergeSort(nums, mid + 1, end);
            merge(nums,start,mid,end);
        }
    }

    private static void merge(int[] nums, int start, int mid, int end){
        int leftLength = mid - start + 1;
        int rightLength = end - mid;

        int[] left = new int[leftLength];
        int[] right = new int[rightLength];

        for (int i = 0; i < leftLength; i ++){
            left[i] = nums[start + i];
        }
        for (int j = 0; j < rightLength; j ++){
            right[j] = nums[mid + 1+ j];
        }

        int index = start;
        int i = 0;
        int j = 0;

        while (i < leftLength && j < rightLength){
            if (left[i] <= right[j]){
                nums[index++] = left[i++];
            }else{
                nums[index++] = right[j++];
            }
        }
        while(i < leftLength){
            nums[index++] = left[i++];
        }
        while(j < rightLength){
            nums[index++] = right[j++];
        }
    }
}

