package lc_company;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Pro752_bfs {
    public static void main(String[] args) {
        System.out.println(2>>1);
//        String[] deadends = {"0201","0101","0102","1212","2002"};
//        String target = "0202";
//        int c = new Pro752_bfs().openLock(deadends, target);
//        System.out.println(c);
    }
    public int openLock(String[] deadends, String target) {
        if(target == null || target.length()!=4)
            return -1;
        Set<String> set = new HashSet<>();
        for (String s:deadends) {
            set.add(s);
        }
        if(set.contains("0000"))
            return -1;
        int count = 0;
        Queue<String> queue = new LinkedList<>();
        queue.add("0000");
        queue.add("#");
        while(!queue.isEmpty())
        {
            StringBuilder temp = new StringBuilder(queue.poll());
            System.out.println(temp);
            if(temp.toString().equals("#")) {
                if(queue.isEmpty())
                    break;
                count++;
                queue.add("#");
                continue;
            }
            else if(temp.toString().equals(target))
            {
                return count;
            }
            for (int i = 0; i < 4; i++) {
                int t = temp.charAt(i) - '0';
                int tadd = (t + 1) % 10;
                int tdel = (t - 1) == -1 ? 9 : t - 1;
                temp.setCharAt(i, (char)('0' + tadd));
                if(!set.contains(temp.toString()))
                {
                    queue.add(temp.toString());
                    set.add(temp.toString());
                }
                temp.setCharAt(i, (char)('0' + tdel));
                if(!set.contains(temp.toString()))
                {
                    queue.add(temp.toString());
                    set.add(temp.toString());
                }
                temp.setCharAt(i, (char)('0' + t));
            }

        }
        return -1;
    }
}
