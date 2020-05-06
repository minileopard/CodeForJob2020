package companytest;

import java.util.*;

public class April_26_tx_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().toString());
        List<ArrayList<String>> lists = new ArrayList<ArrayList<String>>(n);
        for(int i = 0; i < n; i++)
        {
            int len = Integer.parseInt(sc.nextLine().toString());
            ArrayList<String> temp = new ArrayList<>();
            for(int j =0 ;j < len; j++)
            {
                temp.add(sc.nextLine());
            }
            lists.add(temp);
        }
        //
        Queue<Integer> que = new ArrayDeque<>();
        for(int i = 0; i < n; i++)
        {
            que.clear();
            ArrayList<String> temp = lists.get(i);
            for(String s:temp)
            {
                String[] ts = s.split(" ");
                if(ts.length == 1)
                {
                   if(ts[0].equals("TOP") && que.isEmpty() || ts[0].equals("POP") && que.isEmpty())
                   {
                       System.out.println("-1");
                   }else if(ts[0].equals("TOP"))
                   {
                       System.out.println(que.peek());
                   }
                   else if(ts[0].equals("POP") )
                   {
                       que.poll();
                   }
                   else if(ts[0].equals("SIZE"))
                   {
                       System.out.println(que.size());
                   }else if(ts[0].equals("CLEAR"))
                   {
                        que.clear();
                   }
                }else if(ts.length == 2 && ts[0].equals("PUSH"))
                {
                    que.offer(Integer.parseInt(ts[1]));
                }
            }
        }
    }
}
