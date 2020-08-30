package companytest;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class mt829_3 {
    static int res = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int posM = sc.nextInt(), posT = sc.nextInt();
        if(N <= 1 || posM == posT)
        {
            System.out.println(0);
            return;
        }
        if(N == 2)
        {
            System.out.println(1);
            return;
        }
        int[][] nums = new int[N-1][2];
        for (int i = 0; i < N-1; i++) {
            nums[i][0] = sc.nextInt();
            nums[i][1] = sc.nextInt();
        }
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < N - 1; i++) {
            List<Integer> temp = map.getOrDefault(nums[i][0], new LinkedList<>());
            temp.add(nums[i][1]);
            map.put(nums[i][0], temp);
            temp = map.getOrDefault(nums[i][1], new LinkedList<>());
            temp.add(nums[i][0]);
            map.put(nums[i][1], temp);
        }
        boolean[] flag = new boolean[N];
        fun(map, posM, flag, 0, posT, false);
        System.out.println(res);

    }
    public static void fun(HashMap<Integer,List<Integer>> map, int key, boolean[] flag, int len, int posT, boolean flagT)
    {
        List<Integer> list = map.get(key);
        if(key == posT)
        {
            flagT = true;
        }
        if(flagT)
        {
            res = Math.max(res, len);
        }
        flag[key - 1] = true;
        for(int i:list)
        {
            if(!flag[i-1])
            {
                fun(map, i, flag, len + 1, posT, flagT);
            }
        }
    }
}
/*
5 1 2
2 1
3 1
4 2
5 3

5 4 5
2 1
3 1
4 2
5 3
 */