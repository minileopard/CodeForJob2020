package lc_hot100;

import java.util.Stack;

public class Pro394 {
    public static void main(String[] args) {
        System.out.println(new Pro394().decodeString("aaa"));
    }
    public String decodeString(String s) {
        if(s == null || s.length() == 0)
            return s;
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); ) {
            char c = s.charAt(i);
            StringBuilder tempc = new StringBuilder();
            while (c >= 'a' && c <= 'z' || c <= 'Z' && c >= 'A') {
                tempc.append(c);
                if(++i >= s.length())
                    break;
                c = s.charAt(i);
            }
            if (tempc.length() > 0) {
                while (!stack.isEmpty() && stack.peek() != "[") {
                    tempc.insert(0,stack.pop());
                }
                stack.add(tempc.toString());
            }
            StringBuilder tempi = new StringBuilder();
            while (c <= '9' && c >= '0') {
                tempi.append(c);
                if(++i >= s.length())
                    break;
                c = s.charAt(i);
            }
            if (tempi.length() > 0) {
                stack.add(tempi.toString());
            }
            if (c == '[')
            {
                stack.add("[");
                i++;
            }

            if (c == ']') {
                String temppart = stack.pop();//取出括号中的字符串
                stack.pop();//弹掉左括号
                int times = Integer.parseInt(stack.pop());//看看括号外的倍数
                StringBuilder tt = new StringBuilder();
                for (int ti = 0; ti < times; ti++) {
                    tt.append(temppart);
                }
                while (!stack.isEmpty() && stack.peek() != "[") {
                    tt.insert(0,stack.pop());
                }

                stack.add(tt.toString());
                i++;
            }
        }
        return stack.pop();
    }
}
