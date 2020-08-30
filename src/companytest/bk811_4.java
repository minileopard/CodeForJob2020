package companytest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class bk811_4 {
    static int mod = 1000000007;
    static boolean[] flag;
    static long sum = 0;
    static long[][] C;
    static List<Integer> list;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] nums = new int[M][4];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < 4; j++) {
                nums[i][j] = sc.nextInt();
            }
        }
        //计算组合数
        int Clen = 1000;
        C = new long[Clen+1][Clen+1];
        for (int i = 1; i <= Clen; i++) {
            C[i][1] = i;
            C[i][i] = 1;
        }
        for (int i = 2; i <= Clen ; i++) {
            for (int j = 2; j < i ; j++) {
                C[i][j] = (C[i-1][j-1] + C[i-1][j]);
            }
        }

        
        flag = new boolean[N];
        long[][] matrix = new long[N][N];
        for (int i = 0; i < M; i++) {
            long temp = C[nums[i][2]][nums[i][3]];
            matrix[nums[i][0]-1][nums[i][1]-1] = temp;
            matrix[nums[i][1]-1][nums[i][0]-1] = temp;
        }
        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
        list = new ArrayList<Integer>();
        dfs(matrix, 0, flag, 0);
        if(list.size() < N)
            System.out.println(-1);
        else
            System.out.println(sum % mod);
    }
    public static void dfs(long[][] matrix, int node, boolean[] flag, int count)
    {
        if(count == matrix.length)
            return;
        long max = 0;
        int index = node;
        flag[node] = true;
        list.add(node);
        for (int i = 0; i < matrix[0].length; i++) {
            if(i == node || flag[i] == true)
                continue;
            for (int j = 0; j < list.size(); j++) {
                if(matrix[list.get(j)][i] > max)
                {
                    max = matrix[list.get(j)][i];
                    index = i;
                }
            }
        }
        sum += max;
        sum %= mod;
        dfs(matrix, index, flag, count + 1);
    }
}
/*
5 5
1 2 1 1
1 5 1 1
3 5 1 1
2 4 1 1
4 5 2 1

5 5
1 2 1 1
1 5 1 1
3 5 1 1
3 4 1 1
4 5 2 1
 */