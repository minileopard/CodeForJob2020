package companytest;

import java.util.Scanner;

public class mt829_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        int[] B = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
            B[i] = -1;
        }
        int T = sc.nextInt();
        while(T-- > 0)
        {
            int oper = sc.nextInt();
            if(oper == 2)
            {
                int x = sc.nextInt();
                System.out.println(B[x-1]);
            }else if(oper == 1)
            {
                int k = sc.nextInt();
                int x = sc.nextInt();
                int y = sc.nextInt();
                for (int i = y - 1; i < y + k - 1; i++) {
                    B[i] = A[x-1];
                    x++;
                }
            }
        }
    }
}
/*
5
1 2 3 4 5
5
2 1
2 5
1 2 3 4
2 3
2 5
 */