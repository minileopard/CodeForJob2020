package companytest;

import java.util.Scanner;

public class pdd_802_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt(), N = sc.nextInt();
        if(K == 0)
        {
            System.out.println("paradox");
            return;
        }
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        int back = 0;
        for (int i = 0; i < N; i++) {
            if(K - nums[i] == 0)
            {
                System.out.println("paradox");
                return;
            }else if(K - nums[i] > 0)
            {
                K = K - nums[i];
            }else//回退
            {
                K = nums[i] - K;
                back++;
            }
        }
        System.out.println(K + " " + back);
    }
}
