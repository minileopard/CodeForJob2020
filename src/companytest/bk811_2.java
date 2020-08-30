package companytest;

import java.util.Scanner;

public class bk811_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-->0)
        {
            int N = sc.nextInt();
            int M = sc.nextInt();
            if(N == 1 && M == 1)
            {
                System.out.println(2);
                continue;
            }
            if((N & 1) == 0 || (M & 1) == 0)
            {
                System.out.println(2);
                continue;
            }
            int min = Math.min(fun(N), fun(M));
            System.out.println(min);
        }
    }
    //求不为1的最小因子
    public static int fun(int x)
    {
        if((x&1) == 0)
            return 2;
        for (int i = 3; i <= x; i++) {
            if(x % i == 0)
                return i;
        }
        return x;
    }

}
