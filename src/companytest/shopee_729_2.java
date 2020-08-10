package companytest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class shopee_729_2 {
    static List<Integer> res = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] list = input.split(" ");
        int[] nums = new int[list.length];
        for (int i = 0; i < list.length; i++) {
            nums[i] = Integer.parseInt(list[i]);
        }
        dfs(nums, 0, nums.length-1);
        StringBuilder sb = new StringBuilder();
        for(int i:res)
        {
            sb.append(i);
            sb.append(' ');
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());
    }
    public static void dfs(int[] nums, int s, int e)
    {
        if(s > e || s < 0 || e < 0)
            return;
        if(s == e)
        {
            res.add(nums[s]);
            return;
        }
        int root = nums[s], right = -1;
        for(int i = s + 1; i <= e; i++)
        {
            if(nums[i] >= root)
            {
                right = i;
                break;
            }
        }
        if(right == -1 || right == s+1)
        {
            dfs(nums, s+1, e);
        }else {
            dfs(nums, s + 1, right - 1);
            dfs(nums, right, e);
        }
    }
}
