package companytest;

import java.util.Scanner;

public class dd821_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if(N == 1)
        {
            System.out.println(1);
            return;
        }

        long[] list = new long[N*N];
        list[0] = 1;
        list[1] = 1;
        for (int i = 2; i < list.length; i++) {
            list[i] = list[i-1] + list[i-2];
        }
        long[][] nums = new long[N][N];
        int[][] move = {{0, 1},{1, 0},{0,-1},{-1,0}};//右，下，左，上
        int moveindex = 0, listindex = list.length - 1;
        int r = 0, c = 0;
        boolean[][] flag = new boolean[N][N];
        flag[r][c] = true;
        nums[r][c] = list[listindex--];
        int tr = r, tc = c;
        for (int i = 1; i < N*N; ) {
            tr += move[moveindex][0];
            tc += move[moveindex][1];
            //需要变化方向了
            if(tr < 0 || tr >= N || tc < 0 || tc >= N || flag[tr][tc])
            {
                tr -= move[moveindex][0];
                tc -= move[moveindex][1];
                moveindex = (moveindex + 1) % 4;
            }else
            {
                flag[tr][tc] = true;
                nums[tr][tc] = list[listindex--];
                i++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(long[] temp:nums)
        {
            for(long i:temp)
            {
                sb.append(i + " ");
            }
            sb.deleteCharAt(sb.length()-1);
            sb.append("\n");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());
    }
}
