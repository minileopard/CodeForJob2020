package companyexercise;

import java.util.Stack;

public class zj716 {
    public static void main(String[] args) {
        zj716 zj = new zj716();
        int[] A = {0,1,0,2,1,0,1,3,2,1,2,1,3};//0,1,0,2,1,0,1,3,2,1,2,1,3
        System.out.println(zj.trap(A));
    }
    public int trap(int[] A) {
        int len = A.length;
        if(len == 0)
            return 0;
        int left = 0, right = 0, sum = 0;
        while(right < len)
        {
            for(int i = left + 1; i < len - 1; i++)
            {
                if(A[i+1] <= A[i])
                {
                    right = i;
                    break;
                }
            }
            int width = right - left;
            int height = Math.min(A[left], A[right]);
            sum += width * height;
            for(int i = left+1; i < right; i++)
            {
                sum -= A[i];
            }
            left = right;
        }
        return sum;
    }
    public int trapMonotonicStack(int[] A) {
        //单调栈，维持一个单调递减栈
        int len = A.length, sum = 0;
        if(len == 0)
            return 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(int i = 1; i < len; i++)
        {
            int top = stack.peek();
            while(A[top] < A[i])
            {
                stack.pop();
                if(stack.isEmpty())
                    break;
                int cur = stack.peek();
                sum += (i - cur - 1) * (Math.min(A[cur], A[i]) - A[top]);
                top = stack.peek();
            }
            stack.push(i);
        }
        return sum;
    }
}
