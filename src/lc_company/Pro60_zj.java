package lc_company;

import java.util.ArrayList;
import java.util.List;

public class Pro60_zj {
    public static void main(String[] args) {
        Pro60_zj p = new Pro60_zj();
//        int n = 4;
//        for(int k = 1; k <= 24; k++)
//            System.out.println(p.getPermutation2(n, k));
        int[] nums = {1,2,3};
        System.out.println(Math.sqrt(1));
//        for(List<Integer> l:p.permute(nums))
//        {
//            System.out.println(l.toString());
//        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            temp.add(nums[i]);
        }
        dfs(res, temp, 0, nums.length);
        return res;
    }
    public void dfs(List<List<Integer>> res, List<Integer> temp, int index, int len)
    {
        if(index == len-1)
        {
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i = index; i < len; i++)
        {
            Integer t = temp.get(i);
            temp.set(i, temp.get(index));
            temp.set(index, t);
            dfs(res, temp, index+1, len);
            t = temp.get(i);
            temp.set(i, temp.get(index));
            temp.set(index, t);
        }
    }
    public String getPermutation2(int n, int k) {
        int[] fac = new int[n];
        fac[0] = 1;
        List<Integer> bucket = new ArrayList<Integer>();
        for(int i = 1; i < n; i++) {
            fac[i] = i * fac[i - 1];
        }
        for(int i = 0; i < n; i++) {
            bucket.add(i + 1);
        }

        k--;
        StringBuilder sb = new StringBuilder();
        for(int i = n - 1; i >=0; i--) {
            int idx = k / fac[i];
            sb.append(bucket.get(idx));
            k -= idx * fac[i];
            bucket.remove(idx);
        }
        return sb.toString();
    }
    public String getPermutation(int n, int k) {
        if(n == 1)
            return "1";
        int[] jc = new int[n];
        caljc(n, jc);
        int[] num = new int[n];
        boolean[] flag = new boolean[n];
        for (int i = 1; i <= n; i++) {
            num[i-1] = i;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = n-2; i >=0 ; i--) {
            int shan = k / jc[i], ys = k % jc[i];
            //找到第shan小的下标
            int index = 0, count = 0;
            if(ys == 0)
                shan--;
            while(count <= shan && index < n)
            {
                if(!flag[index])
                {
                    count++;
                }
                index++;
            }
            index--;
            if(ys == 0)
            {
                //找到前一个不是true的
                flag[index] = true;
                sb.append(num[index]);
                //后面按照倒叙插入
                for(int j = n - 1; j >= 0; j--)
                {
                    if(!flag[j])
                        sb.append(num[j]);
                }
                break;
            }else
            {
                flag[index] = true;
                sb.append(num[index]);
                k = ys;
            }
        }
        return sb.toString();
    }
    public int caljc(int n, int[] jc)
    {
        if(n == 1)
        {
            jc[n-1] = 1;
            return 1;
        }
        int t = n * caljc(n-1, jc);
        jc[n-1] = t;
        return t;
    }
}
