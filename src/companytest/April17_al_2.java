package companytest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//输出序列没有顺子那一题
public class April17_al_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        List<int[]> res = new ArrayList<>();
        int[] list = new int[n];
        for(int i = 1; i <= n; i++)
        {
            list[i-1] = i;
        }
        April17_al_2 p = new April17_al_2();
        p.dfs(list, 0, res);
        for(int[] t:res)
        {
            System.out.println(Arrays.toString(t));
        }
    }
    public void dfs(int[] list, int start, List<int[]> res)
    {
        if(start == list.length - 1)
        {
            
            res.add(list.clone());
            return;
        }
        for(int i = start; i < list.length; i++)
        {
            swap(list, i, start);
            dfs(list, start + 1, res);
            swap(list, i, start);
        }
    }
    public void swap(int[] N, int s, int t)
    {
        int temp = N[s];
        N[s] = N[t];
        N[t] = temp;
    }
}
