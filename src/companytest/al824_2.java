package companytest;

import java.util.Scanner;

public class al824_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0)
        {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] nums = new int[m][3];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < 3; j++) {
                    nums[i][j] = sc.nextInt();
                }
            }
            int Q = sc.nextInt();
            int[] target = new int[Q];
            for (int i = 0; i < Q; i++) {
                target[i] = sc.nextInt();
            }
            for (int i = 0; i < Q; i++) {
                System.out.println(0);
            }

        }
    }
}
/*
2
2 1
0 1 2
3
1
2
3
3 3
0 1 2
0 2 4
1 2 5
5
0
2
3
4
5
 */