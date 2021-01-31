package week2;

import java.util.ArrayList;
import java.util.List;

//77. 组合 https://leetcode-cn.com/problems/combinations/ 22.03
public class Combine {
    private static List<List<Integer>> ans = new ArrayList<>();

    public static void main(String[] args) {
        List<List<Integer>> combine = combine(5, 3);
        System.out.println("res = " + combine);
    }


    public static List<List<Integer>> combine(int n, int k) {
        getCombine(n, k, 1, new ArrayList<Integer>());
        return ans;
    }

    private static void getCombine(int n, int k, int start, ArrayList<Integer> list) {
        if (list != null && list.size() == k) {
            ans.add(list);
            return;
        }

        for (int i = start; i <= n - k + 1; i++) {
            list.add(i);
            getCombine(n, k - 1, start + 1, list);
            // TODO: 2021/1/31  重点理解此处的删除逻辑！！！ ？？？
            list.remove(list.size() - 1);
        }
    }




    //调试
    /*public static List<List<Integer>> _combine(int n, int k) {
        _getCombine(n, k, 1, new ArrayList<>());
        return ans;
    }

    public static void _getCombine(int n, int k, int start, List<Integer> list) {
        System.out.println("getCombine() called with: n = [" + n + "], k = [" + k + "], start = [" + start + "], list = [" + list + "]");
        if (k == 0) {
            System.out.println("ans ready to add " + list);
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= n - k + 1; i++) {
            System.out.println("list ready to add " + i);
            list.add(i);
            _getCombine(n, k - 1, i + 1, list);
            System.out.println("ready to remove list.get(list.size() - 1) : " + list.get(list.size() - 1));
            list.remove(list.size() - 1);
        }
    }*/


}
