package companytest;

import java.util.Scanner;

public class pdd_802_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lunch = sc.nextInt();
        int dinner = sc.nextInt();
        int T = sc.nextInt();
        if(T == 0)
        {
            System.out.println(0);
            return;
        }
        int[][] nums = new int[lunch+dinner][2];
        for (int i = 0; i < nums.length; i++) {
            nums[i][0] = sc.nextInt();
            nums[i][1] = sc.nextInt();
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= lunch; i++) {
            int lmw = 0, lhot = 0;
            if(i < lunch)
            {
                lmw = nums[i][1];
                lhot = nums[i][0];
            }

            for (int j = lunch; j <= lunch+dinner; j++) {
                int dmw = 0, dhot = 0;
                if(j < lunch+dinner)
                {
                    dmw = nums[j][1];
                    dhot = nums[j][0];
                }
                if(lmw + dmw >= T)
                {
                    min = Math.min(dhot+lhot, min);
                }
            }
        }
        if(min!=Integer.MAX_VALUE)
            System.out.println(min);
        else
            System.out.println(-1);
    }
}
/*
3 2 10
4 2
8 9
4 3
5 4
4 3

和这一题有点像
计蒜客 awnKswater ( 完全背包问题 | 最小花费 | 记录最大重量 )
https://blog.csdn.net/weixin_44510468/article/details/103251955
 */