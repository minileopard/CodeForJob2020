package lc_hot100;

import java.util.ArrayList;
import java.util.List;

public class Pro448 {
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> res = new Pro448().findDisappearedNumbers(nums);
        for (int i:res) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums == null)
            return null;
        int len = nums.length;
        List<Integer> list = new ArrayList<Integer>(len);
        for (int i = 0; i < len; i++) {
            int aim = nums[Math.abs(nums[i]) - 1];
            if(aim > 0)
            {
                nums[Math.abs(nums[i]) - 1] = -nums[Math.abs(nums[i]) - 1];
            }
        }
        for (int i = 0; i < len; i++) {
            if(nums[i] > 0)
                list.add(i+1);
        }
        return list;
    }
}
