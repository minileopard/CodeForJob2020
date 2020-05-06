package lc_hot100;

import java.util.HashMap;

public class Pro560 {
    public static void main(String[] args) {
        int[] nums = {-1,1,-1};
        System.out.println(new Pro560().subarraySum(nums, 0));
    }
    public int subarraySum(int[] nums, int k) {
        if(nums == null || nums.length == 0)
            return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);//和为0, 出现了一次
        int count = 0, sum = 0;
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            if(map.containsKey(sum - k))
                count += map.get(sum - k);
            int cs = map.getOrDefault(sum, 0);
            map.put(sum, cs + 1);
        }
        return count;
    }
}
