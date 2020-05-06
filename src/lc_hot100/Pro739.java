package lc_hot100;

import java.util.Stack;

public class Pro739 {
    public static void main(String[] args) {
        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] res = new Pro739().dailyTemperatures(T);
        for(int i :res)
            System.out.print(i);
        System.out.println();
    }
    public int[] dailyTemperatures(int[] T) {
        if(T == null || T.length == 0)
            return new int[0];
        int len = T.length;
        int[] res = new int[len];
        Stack<Integer> stack = new Stack<>();
        stack.push(len-1);
        res[len-1] = 0;
        for(int i = len - 2; i >= 0; i--)
        {
            if(T[i] < T[stack.peek()])
            {
                res[i] = 1;
                stack.push(i);
            }else
            {
                //找到栈中所有比当前小的
                while(!stack.isEmpty() &&T[i] >= T[stack.peek()])
                {
                    stack.pop();
                }
                if(stack.isEmpty())
                {
                    res[i] = 0;
                }else
                {
                    res[i] = stack.peek() - i;
                }
                stack.push(i);
            }
        }
        return res;
    }
}
