package companytest;

import java.util.Scanner;

public class dj810_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int A = sc.nextInt();
        int x = sc.nextInt();
        int[] nums = new int[N];
        int sum = 0;
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
            sum+=nums[i];
        }
        int max = x*60*A;
        if(max > sum)
        {
            int temp = sum / A;
            if(sum % A > 0)
                temp++;
            System.out.println(temp);
        }else if(max < sum)
        {
            System.out.println((sum -60*x*A) +60*x);
        }else {
            System.out.println(sum);
        }
    }
}
/*
8
2
8
60
60
60
60
60
60
60
60

4
3
3
333
77
100
13
 */