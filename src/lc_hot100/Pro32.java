package lc_hot100;

import java.util.Stack;

public class Pro32 {
    public static void main(String[] args) {
        String s = ")())(())";
        System.out.println(longestValidParentheses(s));
    }
    public static int longestValidParentheses(String s) {
        if(s==null || s.length()==0)
            return 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxlen = 0;
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if(temp == '(')
            {
                stack.push(i);
            }else{
                stack.pop();
                if(!stack.isEmpty()) {
                    maxlen = Math.max(i - stack.peek(), maxlen);
                }else {
                    stack.push(i);
                }
            }
        }
        return maxlen;
    }
}
