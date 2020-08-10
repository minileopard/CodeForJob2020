package companytest;

import java.util.Scanner;

public class wy_808_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        int res = 0;
        for (int i = 0; i < N; i++) {
            res += findCount(nums[i]);
        }
        System.out.println(res);
    }
    public static int findCount(int N)
    {
        if(N <= 1)
            return 0;
        int count = N / 2;
        return count;
    }
}
