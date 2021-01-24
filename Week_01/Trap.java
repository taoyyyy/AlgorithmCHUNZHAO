import java.util.Stack;

//接雨水 https://leetcode-cn.com/problems/trapping-rain-water/  22.00
// TODO: 2021/1/24  需要继续理解
public class Trap {
    public int trap6(int[] height) {
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        int current = 0;
        while (current < height.length) {
            while (!stack.isEmpty() && height[current] > height[stack.peek()]){
                int mediaHeight = height[stack.pop()];
                if (stack.isEmpty()) break;
                int leftHeight = height[stack.peek()];
                int rightHeight = height[current];
                int distance = current - stack.peek() - 1;
                sum = sum + (rightHeight - leftHeight - mediaHeight) * distance;
            }
            stack.push(height[current]);
            current++;
        }
        return sum;
    }
}
