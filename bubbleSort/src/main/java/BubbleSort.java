public class BubbleSort {

    public static void main(String[] args){
        int[] nums = new int[] {10,2,3,4,2,1,6,8,2,2,1};
        System.out.println(bubbleSort(nums));
    }
    private static int[] bubbleSort(int[] nums){
        // check input before operation;
        if (nums == null || nums.length == 0){
            return null;
        }
        for (int i = 0; i < nums.length; i ++){
            for (int j = 1; j < nums.length - i; j ++){
                if(nums[j] < nums[j - 1]){
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                }
            }
        }
        return nums;
    }
}
