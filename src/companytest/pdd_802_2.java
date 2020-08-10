package companytest;

import java.util.Scanner;

public class pdd_802_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] nums = new int[N][6];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 6; j++) {
                nums[i][j] = sc.nextInt();
            }
        }
        System.out.println(N-1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N-1; i++) {
            sb.append(1);
            sb.append(' ');
        }
        sb.setCharAt(0,'2');
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());
    }
}
