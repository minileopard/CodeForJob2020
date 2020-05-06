package companytest;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class pdd_5_6_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int count = 0;
        Set<Integer> set = new HashSet<Integer>();
        int max = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int temp = nums[i];
            max = Math.max(max, temp);
            min = Math.min(min, temp);
            if(set.contains(temp))
            {
                if(max - min + 1 == set.size())
                {
                    max++;
                    temp = max;
                }else
                {
                    while(set.contains(temp))
                    {
                        temp++;
                    }
                }

                set.add(temp);
                count += temp - nums[i];
            }else
            {
                set.add(temp);
            }
        }
        System.out.println(count);
    }
}
