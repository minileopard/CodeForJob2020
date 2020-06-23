package companytest;

import java.util.Arrays;
import java.util.Scanner;

public class pdd_5_6_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        //先排序
        Arrays.sort(nums);
        int count = 0;
        for (int i = 1; i < n; i++) {
            if(nums[i] <= nums[i - 1])
            {
                count += nums[i - 1] + 1 - nums[i];
                nums[i] = nums[i - 1] + 1;
            }
        }
        System.out.println(count);
    }
}
/*
4
1 3 1 4
输出
1

拼多多笔试题目
https://www.nowcoder.com/discuss/422804?type=post&order=time&pos=&page=1&channel=&source_id=1&subType=2
https://www.nowcoder.com/discuss/423108?type=post&order=time&pos=&page=1&channel=&source_id=1
 */