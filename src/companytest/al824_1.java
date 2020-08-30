package companytest;

import java.util.Scanner;

public class al824_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        double k1 = (double)b / a;
        double k2 = (double)B / A;
        int x = 0, y = 0;
        if(k1 == k2)
        {
            System.out.println(A + " " + B);
        }else if(k1 < k2)
        {
            x = (A / a) * a;
            y = b * x / a;
        }else
        {
            y = (B / b) * b;
            x = y / b * a;
        }
        System.out.println(x + " " + y);
    }
}
