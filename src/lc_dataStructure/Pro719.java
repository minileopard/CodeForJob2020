package lc_dataStructure;

import java.util.Arrays;

public class Pro719 {
    public static void main(String[] args) {
        int[] nums = {1,3,1,1,1,1};
        int k = 5;
        Pro719 p = new Pro719();
        System.out.println(p.smallestDistancePair(nums, k));
    }
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int len=nums.length;
        int low=0;
        int high=nums[len-1]-nums[0];

        while(low<high){
            int mid=low+(high-low)/2;
            int count=0;
            int left=0;
            for(int right=0; right<len; right++){
                while(nums[right]-nums[left]>mid) left++;
                count+=right-left;
            }

            if(count>=k){
                high=mid;
            }else{
                low=mid+1;
            }
        }
        return low;
    }
}
