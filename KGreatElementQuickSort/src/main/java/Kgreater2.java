public class Kgreater2 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{6, 2, 5, 8, 9, 9, 13, 10, 11,6,1};
        Kgreater2 kgreater2 = new Kgreater2();
        System.out.println(kgreater2.findKthLargest(nums1, 4));
    }

    public int findKthLargest(int[] nums, int k) {
        // check input before operation;
        if (nums == null || nums.length == 0) {
            return -1;
        }
        return quickSort1(nums, 0, nums.length - 1, k);
    }

    private int quickSort1(int[] nums, int start, int end, int k) {

        if (start == end) {
            return nums[end];
        }
        int pivotPosition = partition1(nums, start, end);
        // pivotPosition included;
        int laterNumber = nums.length - pivotPosition;
        if (laterNumber == k) {
            return nums[pivotPosition];
        } else if (laterNumber > k) {
            return quickSort1(nums, pivotPosition + 1, end, k);
        } else {
            return quickSort1(nums, start, pivotPosition - 1, k - laterNumber);
        }
    }

    private int partition1(int[] nums, int start, int end) {
        int pivot = nums[end];
        int j = start - 1;
        for (int i = start; i < end; i ++) {
            if (nums[i] <= pivot) {
                j ++;
                if (i != j ) {
                    swap(nums, i, j);
                }
            }
        }
        swap(nums, j + 1, end);
        return j + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
