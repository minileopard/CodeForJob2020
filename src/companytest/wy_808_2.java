package companytest;

import java.util.Arrays;
import java.util.Scanner;

public class wy_808_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] list = input.split(" ");
        int N = list.length;
        long[] nums = new long[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Long.parseLong(list[i]);
        }
        long count = 0;
        boolean e, m, h;
        while(true)
        {
            e = false;m = false; h = false;
            if(nums[0] >= 1)
            {
                nums[0]--;
                e = true;
            }else if(nums[1] >= 1)
            {
                nums[1]--;
                e = true;
            }

            if(nums[2] >= 1)
            {
                nums[2]--;
                m = true;
            }else if(nums[1] >= 1)
            {
                nums[1]--;
                m = true;
            }else if(nums[3] >= 1)
            {
                nums[3]--;
                m = true;
            }

            if(nums[4] >= 1)
            {
                nums[4]--;
                h = true;
            }else if(nums[3] >= 1)
            {
                nums[3]--;
                h = true;
            }

            if(e && m && h)
                count++;
            else
                break;
        }

        System.out.println(count);
    }
}
