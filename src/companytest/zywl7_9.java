package companytest;

import java.util.*;

/*
招银网络第一次视频面试算法题
表达式求值
给定一个字符串描述的算术表达式，计算出结果值。
输入字符串长度不超过100，合法的字符包括”+, -, *, /, (, )”，”0-9”，字符串内容的合法性及表达式语法的合法性由做题者检查。本题目只涉及整型计算。
输入描述
输入算术表达式 -> 400+5
输出描述
计算出结果值 -> 405
 */
public class zywl7_9 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String input = sc.nextLine();
//        sc.close();
        String input = "1*2*3+2+2+(3*5)";
        LinkedList<String> list = new LinkedList<>();
        int len = input.length(), i = 0;
        while (i < len) {
            char c = input.charAt(i);
            StringBuilder sb = new StringBuilder();
            while (c >= '0' && c <= '9') {
                sb.append(c);
                i++;
                if (i == len)
                    break;
                c = input.charAt(i);
            }
            if (sb.length() > 0) {
                list.add(sb.toString());
                sb.setLength(0);
            }
            if (i == len)
                break;
            if (c == '(' || c == ')' || c == '+' || c == '-' || c == '*' || c == '/') {
                sb.append(c);
                list.add(sb.toString());
                i++;
            } else {
                System.out.printf("Error input Character");
                return;
            }
        }
        for (String s : list)
        {
            System.out.print(s + " ");
        }
        System.out.println();
        Stack<Integer> numstack = new Stack<>();
        Stack<Character> operstack = new Stack<>();
        int index = 0;
        list.addFirst("(");
        list.addLast(")");//加上左右括号强行完成计算
        while(index < list.size()) {
            String temp = list.get(index++);
            if (temp.equals("(")) {
                operstack.add(temp.charAt(0));
            } else if (temp.equals("*") || temp.equals("/")
                    || temp.equals("+") || temp.equals("-")) {
                if (!operstack.isEmpty()) {
                    Character top = operstack.peek();
                    if (top != '(') {
                        int left = 0, right = 0;
                        if (numstack.size() >= 2) {
                            right = numstack.pop();
                            left = numstack.pop();
                        } else {
                            System.out.println("Error input operator");
                            return;
                        }
                        if ((temp.equals("+") || temp.equals("-")) && top == '+') {
                            left = left + right;
                            operstack.pop();
                            numstack.add(left);
                        } else if ((temp.equals("+") || temp.equals("-")) && top == '-') {
                            left = left - right;
                            operstack.pop();
                            numstack.add(left);
                        } else if (top == '*') {
                            left = left * right;
                            operstack.pop();
                            numstack.add(left);
                        } else if (top == '/') {
                            left = left / right;
                            operstack.pop();
                            numstack.add(left);
                        }else
                        {
                            numstack.push(left);
                            numstack.push(right);
                        }
                    }
                }
                operstack.add(temp.charAt(0));
            } else if (temp.equals(")")) {
                while (!operstack.isEmpty()) {
                    Character top = operstack.pop();
                    if(top == '(')
                    {
                        break;
                    }
                    int left = 0, right = 0;
                    if (numstack.size() >= 2) {
                        right = numstack.pop();
                        left = numstack.pop();
                    } else {
                        System.out.println("Error input at )");
                        return;
                    }
                    if (top == '+') {
                        left = left + right;
                    } else if (top == '-') {
                        left = left - right;
                    } else if (top == '*') {
                        left = left * right;
                    } else if (top == '/') {
                        left = left / right;
                    }
                    numstack.add(left);
                }
            }else//数字
            {
                numstack.add(Integer.parseInt(temp));
            }
        }
        System.out.println(numstack.pop());
    }

}