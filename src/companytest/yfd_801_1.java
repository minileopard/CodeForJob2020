package companytest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class yfd_801_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] starts = new int[N];
        int[] ends = new int[N];
        int max = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            starts[i] = sc.nextInt();
            min = Math.min(min, starts[i]);
            ends[i] = sc.nextInt();
            max = Math.max(max, ends[i]);
        }
        int[] cache = new int[max - min + 2];
        for (int i = 0; i < N; i++) {
            for (int j = starts[i]; j < ends[i]; j++) {
                cache[j]++;
            }
        }
        int res = 0;
        for (int i = 0; i < max - min + 2; i++) {
            res = Math.max(cache[i], res);
        }
        System.out.println(res);
    }
    /*
    public static void dfs(List<List<Integer>> path, int index, int count, int N)
    {
        if(index == N-1)
        {
            max = Math.max(max, count);
            return;
        }
        for(int i:path.get(index))
        {
            dfs(path, i, count+1, N);
        }
    }
     */
}
/*
4
1 4
1 2
2 3
3 4
 */