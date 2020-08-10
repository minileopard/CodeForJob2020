package companytest;

import java.util.Scanner;
//最少的钱币数凑钱，贪心算法。
public class kdxf731_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[5];
        int[] values = {1, 5, 10, 50, 100};
        for (int i = 0; i < 5; i++) {
            nums[i] = sc.nextInt();
        }
        int total = sc.nextInt(), res = 0;
        for (int i = 4; i >= 0; i--) {
            int t = Math.min(total / values[i], nums[i]);
            total -= t * values[i];
            res += t;
        }
        if(total == 0)
            System.out.println(res);
        else
            System.out.println(-1);
    }
}
