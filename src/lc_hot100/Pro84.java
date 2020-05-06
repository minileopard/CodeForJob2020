package lc_hot100;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Pro84 {
    public static void main(String[] args) {
        int[] nums = {2,2,5,6,2,3};
        System.out.println(new Pro84().largestRectangleArea_answer2(nums));
    }
    //单调栈
    public int largestRectangleArea_answer2(int[] heights)
    {
        if(heights == null || heights.length == 0)
            return 0;
        int maxarea = 0;
        Stack<Integer> s = new Stack<>();
        s.push(-1);
        for(int i = 0; i <= heights.length; i++)
        {
            int temp, top;
            if(i < heights.length)
                temp = heights[i];
            else
                temp = 0;//尾部设置一个哨兵
            if(i == 0)
            {
                top = 0;//头部设置一个哨兵
            }else {
                top = s.peek();
            }

            if(temp < heights[top])
            {
                //找完栈内大于当前值的值
                while(s.size() > 1 && (heights[s.peek()]) >= temp)
                {
                    int area = heights[s.pop()] * (i - s.peek() - 1);
                    maxarea = Math.max(maxarea, area);
                }
            }
            s.push(i);
        }
        return maxarea;
    }
    //暴力解法
    public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0)
            return 0;
        int maxarea = 0;
        Set<Integer> set = new HashSet<>();
        for (int i:heights) {
            set.add(i);
        }
        for (int s:set) {
            int len = 0;
            for (int i = 0; i < heights.length; i++)
            {
                if(heights[i] >= s)
                {
                    len++;
                }
                if(heights[i] < s || i == heights.length - 1)
                {
                    maxarea = Math.max(maxarea, s * len);
                    len = 0;
                }
            }
        }
        return maxarea;
    }
}
