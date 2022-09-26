import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args){
        int[] nums = new int[] {10,2,3,4,2,1,6,8,2,2,1};
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void bubbleSort (int[] nums) {
        // check input before operation;

        if (nums == null || nums.length == 0) {
            return;
        }

        for (int i = 0; i < nums.length; i ++) {
            for (int j = 1; j < nums.length - i; j ++) {
                if (nums [j - 1] >= nums[j]) {
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                }
            }
        }
    }
}
