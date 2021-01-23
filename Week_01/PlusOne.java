public class PlusOne {
//    66. 加一  https://leetcode-cn.com/problems/plus-one/
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            int i1 = ++digits[i] % 10;
            digits[i] = i1;
            if (digits[i] != 0) return digits;
        }

        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1;//所有的位都是9
        return newDigits;
    }
}
