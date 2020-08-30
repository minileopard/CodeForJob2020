package companytest;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
//是不是类似于信封问题啊，动态规划的。。。
public class sf818_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] nums = new int[N][3];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                nums[i][j] = sc.nextInt();
            }
        }
        Arrays.sort(nums,(o1,o2)->{
            if(o1[1]==o2[1])
                return o1[0] - o2[0];
            else
                return o1[1] - o2[1];
        });
        List<int[]> list = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            list.add(nums[i]);
        }
        //先合并可以合并的区间
        for (int i = 0; i < list.size() - 1; i++) {
            int[] cur = list.get(i);
            int[] next = list.get(i + 1);
            if(cur[1] <= next[0])
            {
                cur[1] = next[1];
                cur[2] = cur[2] + next[2];
                list.remove(i+1);
                i--;
            }
        }
        int[] dp = new int[N];
        dp[0] = list.get(0)[2];
        int maxdp = dp[0];
        for(int i = 1; i < N; i++)
        {
            if(list.get(i)[1] >= list.get(i-1)[0])
            {
                dp[i] = dp[i-1] + list.get(i)[2];
            }else
            {
                dp[i] = dp[i-1];
            }
            maxdp = Math.max(maxdp, dp[i]);
        }
        System.out.println(maxdp);
        //再将不能合并的抉择一下
        for (int i = 0; i < list.size() - 1; i++) {
            int[] cur = list.get(i);
            int[] next = list.get(i+1);
            if(cur[1] > next[0])
            {
                int choose = i;
                if(cur[2] > next[2])
                {
                    choose = i + 1;
                }
                list.remove(choose);
                i--;
            }
        }
        int sum = 0;
        for(int[] temp:list)
        {
            sum += temp[2];
        }
        System.out.println(sum);
    }
}
/*
3
1 3 5
2 7 3
5 10 1

4
1 7 10
2 3 6
3 4 2
4 5 3

6
1 7 10
2 3 6
3 4 2
4 5 3
6 9 4
7 9 5

public class sf818_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] nums = new int[N][3];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                nums[i][j] = sc.nextInt();
            }
        }
        Arrays.sort(nums,(o1,o2)->{
            if(o1[1]==o2[1])
                return o1[0] - o2[0];
            else
                return o1[1] - o2[1];
        });
        List<int[]> list = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            list.add(nums[i]);
        }
        //先合并可以合并的区间
        for (int i = 0; i < list.size() - 1; i++) {
            int[] cur = list.get(i);
            int[] next = list.get(i + 1);
            if(cur[1] <= next[0])
            {
                cur[1] = next[1];
                cur[2] = cur[2] + next[2];
                list.remove(i+1);
                i--;
            }
        }
        //再将不能合并的抉择一下
        for (int i = 0; i < list.size() - 1; i++) {
            int[] cur = list.get(i);
            int[] next = list.get(i+1);
            if(cur[1] > next[0])
            {
                int choose = i;
                if(cur[2] > next[2])
                {
                    choose = i + 1;
                }
                list.remove(choose);
                i--;
            }
        }
        int sum = 0;
        for(int[] temp:list)
        {
            sum += temp[2];
        }
        System.out.println(sum);
    }
}
 */