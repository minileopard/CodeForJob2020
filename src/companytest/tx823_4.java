package companytest;

import java.util.Scanner;

public class tx823_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        int max = 0, min = Integer.MAX_VALUE, sum = 0;
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
            sum += nums[i];
        }
        System.out.println(N);
    }
}
