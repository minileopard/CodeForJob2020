package lc_dataStructure;

import java.util.ArrayList;
import java.util.List;

public class Pro658 {
    public static void main(String[] args) {
        int[] arr = {0,1,1,1,2,3,6,7,8,9};
        int k = 9, x = -1;
        Pro658 p = new Pro658();
        List<Integer> res = p.findClosestElements(arr, k, x);
        System.out.println(res.toString());
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        final int size = arr.length;

        int left = 0;
        int right = size - 1;
        int removeCount = size - k;

        while (removeCount > 0) {
            if (x - arr[left] <= arr[right] - x) {
                right--;
            } else {
                left++;
            }
            removeCount--;
        }

        final ArrayList<Integer> results = new ArrayList<Integer>(k);
        for (int i = 0; i < k; i++) {
            results.add(arr[left + i]);
        }
        return results;
    }
}
