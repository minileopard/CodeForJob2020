package companytest;

import java.util.*;
import java.util.stream.Collectors;

public class pdd_5_6_2 {
    static boolean flag = false;//是否成功
    static int bc = 0;//边长
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T!=0)
        {
            T--;
            int n = sc.nextInt();
            int[] nums = new int[n];
            int sum = 0;
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
                sum += nums[i];
            }
            Arrays.sort(nums);
            if(sum % 4 != 0 || nums[n - 1] > sum / 4)
            {
                System.out.println("NO");
                continue;
            }
            bc = sum / 4;
            boolean[] vis = new boolean[n];
            dfs(vis, nums, 0, 0, 0);
            System.out.println(flag);
        }
    }
    //访问标志，数组，起点，边的和，已完成的边数目。
    public static void dfs(boolean[] vis, int[] nums, int s, int sum, int count)
    {
        if(count == 4)
        {
            flag = true;
            return;
        }
        if(sum == bc)
            dfs(vis, nums, 0, 0, count + 1);
        for(int i = s; !flag && i < nums.length; i++)
        {
            if(vis[i] || sum + nums[i] > bc)
                continue;
            vis[i] = true;
            dfs(vis, nums, i + 1, sum + nums[i], count);
            vis[i] = false;
        }
    }
}
/*
1
8 1 1 1 1 2 3 3 4

1
10 1 1 1 2 1 1 3 2 4 4
https://leetcode-cn.com/problems/matchsticks-to-square/
 */