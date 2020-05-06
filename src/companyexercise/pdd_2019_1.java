package companyexercise;

import java.util.*;

public class pdd_2019_1 {
    public static void main(String[] args) {
        //好聪明的办法，依赖越多，优先级别越低！！
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[] time = new int[n];
        for (int i = 0; i < n; i++) {
            time[i] = sc.nextInt();//时长
        }
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            Set<Integer> temp = map.getOrDefault(r, new TreeSet<>());
            Set<Integer> pre = map.getOrDefault(l, new TreeSet<>());//依赖的东西有没有依赖谁
            temp.add(l);
            for(Integer p:pre)
            {
                temp.add(p);
            }
            map.put(r, temp);
        }
        sc.close();
        //构建(优先级，时长，编号)数组
        int[][] collect = new int[n][3];
        for(int index: map.keySet())
        {
            collect[index - 1][0] = map.get(index).size();
        }
        for (int i = 0; i < n; i++) {
            collect[i][1] = time[i];
            collect[i][2] = i + 1;
        }
        //优先级小->时长短的优先->编号小的优先
        Arrays.sort(collect, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0])
                {
                    if(o1[1] == o2[1])
                    {
                        return o1[2] - o2[2];
                    }else
                    {
                        return o1[1] - o2[1];
                    }
                }else {
                    return o1[0] - o2[0];
                }
            }
        });
        //打印
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(collect[i][2] + " ");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
    }
}
/*
拼多多提前批（7月28号笔试题(第三题))
来自 <https://blog.csdn.net/qq_36836587/article/details/97682367>
输入
5 6
1 2 1 1 1
1 2
1 3
1 4
2 5
3 5
4 5
输出
1 3 4 2 5
 */