import java.util.Arrays;

public class KGreaterElement {
    public static void main(String[] args) {
        int[] nums = new int[]{6, 2, 5, 8, 9, 9, 13, 10, 11};
        KGreaterElement kGreaterElement = new KGreaterElement();
        System.out.println(Arrays.toString(nums));
        System.out.println(kGreaterElement.kElement(nums, 9));
        System.out.println(kGreaterElement.kElement(nums, 7));
    }

    public int kElement(int[] nums, int k) {
        // check before operation;
        if (nums == null || nums.length == 0) {
            return -1;
        }
        return quickSort(nums, 0, nums.length - 1, k);
    }

    private int quickSort(int[] nums, int start, int end, int k) {
        if (start == end) {
            return nums[start];
        }
        int index = partition(nums, start, end);
        // check how many elements before the index (index included);
        int num = index - start + 1;
        if (num == k) {
            return nums[index];
        } else if (num > k) {
            //  target element is in the left part;
            return quickSort(nums, start, index - 1, k);
        } else {
            // target element is in the right part;
            return quickSort(nums, index + 1, end, k - num);
        }
    }

    private int partition(int[] nums, int start, int end) {
        int pivot = nums[end];
        int j = start - 1;
        for (int i = start; i < end; i++) {
            if (nums[i] <= pivot) {
                j++;
                if (i != j) {
                    swap(nums, i , j);
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
