package list;

//13.45
//189. 旋转数组 https://leetcode-cn.com/problems/rotate-array/
public class RotateArray {
    public static void main(String[] args) {
        rotate(new int[]{1,2,3,4,5,6,7},3);
    }

    private static void rotate(int[] nums, int k) {
        int stepNum = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, stepNum - 1);
        reverse(nums, stepNum, nums.length - 1);
    }

    private static void reverse(int[] nums, int start, int end) {
        if (nums == null || nums.length == 0 || start < 0 || end > nums.length - 1) return;
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
