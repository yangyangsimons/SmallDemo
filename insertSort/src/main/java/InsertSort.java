public class InsertSort {
    public static void main(String[] args) {
        int[] nums = new int[]{9, 4, 2, 6, 8, 5, 0, 1, 2, 5, 6};
        System.out.println(InsertSortMain(nums).toString());
    }
    private static int[] InsertSortMain(int[] nums){
        // check input before operation;
        if (nums == null || nums.length == 0){
            return null;
        }

        for (int i = 1; i < nums.length; i ++){
            int j = i - 1; // search from right to left;
            int temp = nums[i];

            // switch one the current element is bigger than previous one;
            while (j >= 0 && nums[j] >= temp){
                nums[j + 1] = nums[j];
                j --;
            }
            nums[j + 1] = temp;
        }
        return nums;
    }
}
