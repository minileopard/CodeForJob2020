package companytest;

import java.util.Scanner;
import java.util.Stack;

public class April_26_tx_4 {
    static Stack<Integer> s1 = new Stack<>();//用来add
    static Stack<Integer> s2 = new Stack<>();//用来poll和peek
    static boolean s1add = true;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < n; i++)
        {
            String list = sc.nextLine();
            String[] temp = list.split(" ");
            if(temp.length == 2 && temp[0].equals("add"))
            {
                add(Integer.parseInt(temp[1]));
            }else if(temp.length == 1)
            {
                if(temp[0].equals("peek"))
                {
                    System.out.println(peek());
                }else if(temp[0].equals("poll"))
                {
                    poll();
                }
            }
        }

    }
    public static void add(int i)
    {
        if(!s1add)
        {
            s1.clear();
            while(!s2.isEmpty())
            {
                s1.push(s2.pop());
            }
            s1add = true;
        }
        s1.push(i);
    }
    public static int peek()
    {
        if(s1add)
        {
            s2.clear();
            while(!s1.isEmpty())
            {
                s2.push(s1.pop());
            }
            s1add = false;
        }
        return s2.peek();
    }
    public static void poll()
    {
        if(s1add)
        {
            s2.clear();
            while(!s1.isEmpty())
            {
                s2.push(s1.pop());
            }
            s1add = false;
        }
        s2.pop();
    }
}
