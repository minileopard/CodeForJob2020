package companytest;

import java.util.Arrays;
import java.util.Scanner;

public class pdd_5_6_2 {
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
            if(sum % 4 != 0)
            {
                System.out.println("NO");
                continue;
            }
            int bc = sum / 4;
            boolean flag = true;
            Arrays.sort(nums);
            int left = 0;
            for(int i = n - 1; i >= left; i--)
            {
                if(nums[i] > bc)
                {
                    flag = false;
                    break;
                }
            }
            if(flag)
            {
                System.out.println("YES");
            }else
            {
                System.out.println("NO");
            }
        }
    }
}
/*
1
8 1 1 1 1 2 3 3 4
 */