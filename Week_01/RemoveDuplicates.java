package list;
//26. 删除排序数组中的重复项 https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
public class RemoveDuplicates {
    public static void main(String[] args) {
        removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4});
    }

    //双指针
    public static int removeDuplicates(int[] nums) {
        if (nums == null) return 0;
        int left = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[left] != nums[i]){
                left++;
                nums[left] = nums[i];
            }
        }
        return left + 1;
    }
}
