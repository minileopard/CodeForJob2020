package companytest;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class qax_801_2 {
    List<int[]> fullList = new LinkedList<>();
    public static void main(String[] args) {
        int[] digit = {1,1,2};
        System.out.println(new qax_801_2().reletive_7(digit));
    }
    public int reletive_7 (int[] digit) {
        // write code here
        int sum = 0;
        fullsort(digit, 0, digit.length-1);
        StringBuilder sb = new StringBuilder();
        for(int[] temp:fullList)
        {
            sb.setLength(0);
            for(int i:temp)
                sb.append(i);
            int num = Integer.parseInt(sb.toString());
            if(num % 7 == 0)
                sum++;
        }
        return sum;
    }
    public void fullsort(int[] digit, int start, int end)
    {
        if(start == end)
        {
            fullList.add(digit.clone());
            return;
        }
        for(int i = start; i <= end; i++)
        {
            swap(digit, i, start);
            fullsort(digit, start + 1, end);
            swap(digit, i, start);
        }
    }
    public void swap(int[] d, int f, int t)
    {
        int temp = d[f];
        d[f] = d[t];
        d[t] = temp;
    }
}
