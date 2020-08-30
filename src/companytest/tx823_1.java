package companytest;

import java.util.Scanner;

public class tx823_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if(i!=k-1)
            {
                sb.append(nums[i]);
                sb.append(' ');
            }
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());
    }
}
