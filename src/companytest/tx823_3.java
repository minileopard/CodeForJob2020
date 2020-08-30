package companytest;

import java.util.Scanner;

public class tx823_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-- > 0)
        {
            int N = sc.nextInt();
            int max = 0;
            int start = N/3;
            int end = N/3*2;
            for (int i = start; i <= end; i++) {
                int temp = funS(i) + funS(N-i);
                max = Math.max(temp, max);
            }
            System.out.println(max);
        }
    }
    public static int funS(int a)
    {
        int sum = 0;
        while(a > 0)
        {
            sum += a % 10;
            a /= 10;
        }
        return sum;
    }
}
