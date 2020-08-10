package lc_dataStructure;

import java.util.*;

public class Pro349 {
    public static void main(String[] args) {
        int[] nums1 = {1,3,2,2};
        int[] nums2 = {2,2};
        Pro349 p = new Pro349();
        System.out.println(Arrays.toString(p.intersection(nums1,nums2)));
    }
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for(int i:nums1)
            s1.add(i);
        for(int i:nums2)
            s2.add(i);
        for(Integer i:s1)
        {
            if(s2.contains(i))
                list.add(i);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
