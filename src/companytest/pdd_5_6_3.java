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
            int left = 1, right = 1, sum = 0;
            if(N==1)
            {
                sum = right;
            }else
            {
                for(int i = 2; i <= N; i++)
                {
                    int temp = left;
                    left = left + right;
                    right = temp;
                }
            }

            left = left % 3;
            right = right % 3;
            A = A % 3;
            B = B % 3;
            sum = left * A + right * B;
            if(sum % 3 == 0)
                System.out.println("YES");
            else
                System.out.println("NO");

//
//            long left = A, right = B;
//            long sum = 0;
//            if(N == 0)
//                sum = left;
//            else if(N == 1)
//                sum = right;
//            for(int i = 2; i <= N; i++)
//            {
//                sum = left + right;
//                left = right;
//                right = sum;
//            }
//            if(sum % 3 == 0)
//                System.out.println("YES");
//            else
//                System.out.println("NO");
        }
    }
}
