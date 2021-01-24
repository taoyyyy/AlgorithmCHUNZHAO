package list;

import java.util.Arrays;

//14.50~16.30
//合并两个有序数组 https://leetcode-cn.com/problems/merge-sorted-array/
public class MergeArray {
    public static void main(String[] args) {
        merge(new int[]{1, 2, 3, 0, 0, FizzBuzz0}, 3, new int[]{2, 5, 6}, 3);
    }


    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1_copy = new int[m];
        System.arraycopy(nums1, 0, nums1_copy, 0, nums1_copy.length);
        int p1 = 0;
        int p2 = 0;
        int p = 0;

        while (p1 < m && p2 < n) {
            if (nums1_copy[p1] < nums2[p2]) {
                nums1[p] = nums1_copy[p1];
                p1++;
            } else {
                nums1[p] = nums2[p2];
                p2++;
            }
            p++;
        }
        if (p1 < m) {
            System.arraycopy(nums1_copy, p1, nums1, p, m - p1);
        } else {
            System.arraycopy(nums2, p2, nums1, p, n - p2);
        }
    }

}
