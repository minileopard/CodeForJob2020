package companytest;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
//处理错误输入的字符串，转成整数
public class kdxf731_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        List<Character> list = new LinkedList<Character>();
        for (int i = 0; i < s.length(); i++) {
            if(i == 0 && s.charAt(i) == '-')
            {
                list.add('-');
            }
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9')
            {
                list.add(s.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char c:list)
            sb.append(c);
        int i = Integer.parseInt(sb.toString());
        System.out.println(i);
    }
}
