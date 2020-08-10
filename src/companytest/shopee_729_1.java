package companytest;

import javax.management.StandardEmitterMBean;
import java.util.*;

public class shopee_729_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int personnum = sc.nextInt();
        int tasknum = sc.nextInt();
        int tasksum = 0, alltime = 0;;
        List<int[]> list = new ArrayList<>();
        List<Integer> cache = new ArrayList<>();
        for(int i = 0; i < personnum; i++){
            int size = sc.nextInt();
            tasksum += size;
            int[] times = new int[size];
            for (int j = 0; j < size; j++) {
                times[j] = sc.nextInt();
                cache.add(times[j]);
            }
            alltime += times[size-1];
            list.add(times.clone());
        }
        if(tasksum < tasknum)
        {
            System.out.println(-1);
            return;
        }else if(tasksum == tasknum)
        {
            System.out.println(alltime);
            return;
        }
        int cz = tasksum - tasknum;
        for (int i = 0; i < cz; i++) {

        }
        System.out.println(tasksum);
    }
    public static int findmax(List<int[]> list)
    {
        int max = 0, maxindex = 0;
        for (int i = 0; i < list.size(); i++) {
            int[] temp = list.get(i);
            if(temp[temp.length-1] > max)
            {
                max = temp[temp.length-1];
                maxindex = i;
            }
        }
        return list.get(maxindex)[list.get(maxindex).length - 2];
    }
}
/*
2 3
2 1 2
2 2 5
 */