package lc_hot100;

import java.util.Arrays;

public class Pro581 {
    public static void main(String[] args) {
        int[] nums = {2, 6, 4, 8, 10, 9, 15};
        System.out.println(new Pro581().findUnsortedSubarray(nums));
    }
    public int findUnsortedSubarray(int[] nums) {
        if(nums == null)
            return 0;
        int[] temp = nums.clone();
        Arrays.sort(temp);
        int len = nums.length;
        int left = 0, right = len - 1;
        while(left < len && nums[left] == temp[left]){
            left++;
        }
        while(right >= 0 && nums[right] == temp[right]){
            right--;
        }
        int count = right - left + 1;
        return count > 0 ? count :0;
    }
}
