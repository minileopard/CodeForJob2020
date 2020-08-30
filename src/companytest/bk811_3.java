package companytest;

import java.util.Scanner;

public class bk811_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        int max = 0;
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
            max = max | nums[i];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int temp = 0;
            for (int j = i; j < N; j++) {
                temp = temp | nums[j];
                if(temp == max)
                {
                    min = Math.min(min, j - i + 1);
                    break;
                }
            }
        }
        System.out.println(min);
    }
}
