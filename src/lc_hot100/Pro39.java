package lc_hot100;

import java.util.ArrayList;
import java.util.List;

public class Pro39 {
    public static void main(String[] args) {
        int[] candi = {2,3,6,7};
        int tar = 7;
        List<List<Integer>> temp = new Pro39().combinationSum(candi, tar);
        StringBuilder sb = new StringBuilder();
        for (List<Integer> tt:temp) {
            for(int t: tt)
            {
                sb.append(t + ",");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append("\n");
        }
        System.out.println(sb);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(candidates == null || target <= 0 || candidates.length == 0)
            return res;
        List<Integer> temp = new ArrayList<>();
        dfs(res, 0, temp, candidates, target, 0);
        return res;
    }
    public void dfs(List<List<Integer>> list, int sum,List<Integer> temp,int[] candidates, int target, int index)
    {
        if(sum == target)
        {
            list.add(new ArrayList<Integer>(temp));
            return;
        }else if(sum > target)
        {
            return;
        }
        for(int i = index; i < candidates.length; i++)
        {
            if(candidates[i] > target)
                break;
            temp.add(candidates[i]);
            dfs(list, sum + candidates[i], temp, candidates, target, i);
            temp.remove(temp.size()-1);
        }
    }
}
