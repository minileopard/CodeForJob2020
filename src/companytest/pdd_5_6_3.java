package companytest;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class pdd_5_6_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T!=0)
        {
            T--;
            int A = sc.nextInt();
            int B = sc.nextInt();
            int N = sc.nextInt();
            for (int i = 2; i <= N; i++) {
                int temp = B;
                B = A + B;
                A = temp;
                A = A % 3;
                B = B % 3;
            }
            if(B % 3 == 0)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
/*
3
1 1 3
1 1 2
15 17 3
 */
