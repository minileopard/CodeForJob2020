package lc_hot100;

import java.util.Stack;

public class Pro394 {
    public static void main(String[] args) {
        System.out.println(new Pro394().decodeString2("2[abc]3[cd]ef"));
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
    public String decodeString2(String s) {
        Stack<String> stack = new Stack<>();
        if(s == null)
            return "";
        int len = s.length();
        if(len == 0)
            return "";
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i < len)
        {
            char c = s.charAt(i);
            if(c == '[')
            {
                stack.push("[");
                i++;
            }
            else if( c == ']')
            {
                //弹栈计算
                String temp = stack.pop();
                stack.pop();//弹掉[
                int count = Integer.parseInt(stack.pop());
                while(count > 0)
                {
                    sb.append(temp);
                    count--;
                }
                //将下面可能的字符串和为一体
                if(!stack.isEmpty() && !stack.peek().equals("["))
                {
                    sb.insert(0, stack.pop());
                }
                stack.push(sb.toString());
                sb.setLength(0);
                i++;
            }
            else if(c <= '9' && c >= '0')
            {
                while(c <= '9' && c >= '0')
                {
                    sb.append(c);
                    i++;
                    if(i == len)
                        break;
                    c = s.charAt(i);
                }
                stack.push(sb.toString());
                sb.setLength(0);
            }
            else if(c <= 'z' && c >= 'a' || c <= 'Z' && c >= 'A')
            {
                while(c <= 'z' && c >= 'a' || c <= 'Z' && c >= 'A')
                {
                    sb.append(c);
                    i++;
                    if(i == len)
                        break;
                    c = s.charAt(i);
                }
                if(!stack.isEmpty() && !stack.peek().equals("["))
                {
                    sb.insert(0, stack.pop());
                }
                stack.push(sb.toString());
                sb.setLength(0);
            }
        }
        return stack.pop();
    }
}
