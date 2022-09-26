import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] nums = new int[]{9, 4, 2, 6, 8, 5, 0, 1, 2, 5, 6};
        InsertSortMain(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void InsertSortMain (int[] nums) {
        // check input before operation;
        if (nums == null || nums.length == 0) {
            return;
        }

        for (int i = 1; i < nums.length; i ++) {
            int j = i - 1;
            int temp = nums[i];

            while (j >= 0 && nums[j] > temp) {
                nums[j + 1] = nums [j];
                j --;
            }

            nums[j + 1] = temp;
        }
    }
}
