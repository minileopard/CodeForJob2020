package companytest;

import java.util.Scanner;

public class mt829_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] nums = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                nums[i][j] = sc.nextInt();
            }
        }
        boolean[] flag = new boolean[N];
        int[] res = new int[N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!flag[nums[i][j]-1])
                {
                    res[i] = nums[i][j];
                    flag[nums[i][j]-1] = true;
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(res[i]);
            sb.append(' ');
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());
    }
}
