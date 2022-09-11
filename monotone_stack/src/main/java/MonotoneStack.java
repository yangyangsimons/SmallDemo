import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class MonotoneStack {

    public static int[] rightGreater(int[] nums) {
        // check input before operation;
        if (nums == null || nums.length == 0) {
            throw new RuntimeException("Illegal input");
        }
        //create result array;
        int[] result = new int[nums.length];
        Deque<Integer> stack = new ArrayDeque<>();
        Arrays.fill(result, -1);
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                int index = stack.pop();
                result[index] = nums[i];
            }
            stack.push(i);
        }
        return result;

    }

    public static int[] rightSmaller(int[] nums) {
        // check input before operation
        if (nums == null || nums.length == 0) {
            throw new RuntimeException("illegal input");
        }
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            // structure a monotone stack;
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                int index = stack.pop();
                result[index] = nums[i];
            }
            stack.push(i);
        }
        return result;
    }

    public static int[] leftGreater(int[] nums) {
        // check input before operation;
        if (nums == null || nums.length == 0) {
            throw new RuntimeException("illegal input");
        }
        //create result array;
        int[] result = new int[nums.length];
        Deque<Integer> stack = new ArrayDeque<>();
        Arrays.fill(result, -1);

        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                int index = stack.pop();
                result[index] = nums[i];
            }
            stack.push(i);
        }
        return result;
    }

    public static int[] leftSmaller(int[] nums) {
        // check input before operation;
        if (nums == null && nums.length == 0) {
            throw new RuntimeException("Illegal input");
        }

        //create result array;
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        //construct monotone stack;
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                int index = stack.pop();
                result[index] = nums[i];
            }
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 4, 1, 5, 3, 4};
        System.out.println(Arrays.toString(rightGreater(nums)));
        System.out.println(Arrays.toString(rightSmaller(nums)));
        System.out.println(Arrays.toString(leftGreater(nums)));
        System.out.println(Arrays.toString(leftSmaller(nums)));
    }
}
