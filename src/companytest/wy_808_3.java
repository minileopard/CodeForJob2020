package companytest;

import java.util.Scanner;

public class wy_808_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        int grade = 0;
        for (int i = 0; i < N; i++) {
            grade += nums[i];
        }
        if(containsFive(grade))
            grade -= 5;
        System.out.println(grade);
    }
    public static boolean containsFive(int N)
    {
        int ws = 10;
        while(N > 0)
        {
            int temp = N - N / ws * ws;
            if(temp == 5)
            {
                return true;
            }
            N = N/ws;
        }
        return false;
    }
}
