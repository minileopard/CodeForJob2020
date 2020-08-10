package lc_hot100;

import java.util.*;

public class Pro18 {
    public static void main(String[] args) {
        int[] nums = {-3,-2,-1,0,0,1,2,3};//1,0,-1,0,-2,2
        int target = 0;
        Pro18 p = new Pro18();
        List<List<Integer>> res = p.fourSum(nums, target);
        StringBuilder sb = new StringBuilder();
        for(List<Integer> list:res)
        {
            for(int i:list)
            {
                sb.append(i);
                sb.append(',');
            }
            sb.deleteCharAt(sb.length()-1);
            sb.append('\n');
        }
        System.out.println(sb.toString());
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        HashMap<Integer, List<int[]>> map = new HashMap();
        List<List<Integer>> res = new ArrayList<>();
        Set<List<Integer>> set = new TreeSet<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                for(int i = 0; i < o1.size(); i++)
                {
                    if(!o1.get(i).equals(o2.get(i)))
                        return o1.get(i) - o2.get(i);
                }
                return 0;
            }
        });
        int len = nums.length;
        Arrays.sort(nums);
        for(int i = 0; i < len - 1; i++)
        {
            for(int j = i + 1; j < len; j++)
            {
                int sum = nums[i] + nums[j];
                if(map.containsKey(target - sum))
                {
                    for(int[] tuple:map.get(target - sum))
                    {
                        //去重
                        if(tuple[1] < i)
                        {
                            List<Integer> tempr = new ArrayList<>();
                            tempr.add(nums[tuple[0]]);
                            tempr.add(nums[tuple[1]]);
                            tempr.add(nums[i]);
                            tempr.add(nums[j]);
                            set.add(tempr);
                        }
                    }
                }
                List<int[]> tl = map.getOrDefault(sum, new ArrayList<>());
                int[] temp = new int[2];
                temp[0] = i;
                temp[1] = j;
                tl.add(temp);
                map.put(sum, tl);
            }
        }
        res.addAll(set);
        return res;
    }
}
