package lc_hot100;

import java.util.Arrays;

public class Pro473 {
    boolean flag = false;//是否成功
    int bc = 0;//边长

    public static void main(String[] args) {
        int[] nums = {3, 3, 3, 3, 4};
        System.out.println(new Pro473().makesquare(nums));
    }
    public boolean makesquare(int[] nums) {
        if(nums == null)
            return false;
        int n = nums.length;
        if(n < 4)
            return false;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        Arrays.sort(nums);
        if(sum % 4 != 0 || nums[n - 1] > sum / 4)
        {
            return false;
        }
        bc = sum / 4;
        boolean[] vis = new boolean[n];
        dfs(vis, nums, 0, 0, 0);
        return flag;
    }
    //回溯法
    //访问标志，数组，起点，边的和，已完成的边数目。
    public void dfs(boolean[] vis, int[] nums, int s, int sum, int count)
    {
        if(count == 4)
        {
            flag = true;
            return;
        }
        if(sum == bc)
            dfs(vis, nums, 0, 0, count + 1);
        for(int i = s; !flag && i < nums.length; i++)
        {
            if(vis[i] || sum + nums[i] > bc)
                continue;
            vis[i] = true;
            dfs(vis, nums, i + 1, sum + nums[i], count);
            vis[i] = false;
        }
    }
}
