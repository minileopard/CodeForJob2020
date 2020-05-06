package companytest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class April_26_hw {
    public static void main(String[] args) {

    }
    public static int Solve(List<ArrayList<Integer>> list)
    {
        if(list == null)
            return -1;
        int len = list.size();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < len; i++)
        {
            ArrayList<Integer> temp = list.get(i);
            int sum = 0;
            for(int w:temp)
            {
                sum += w;
                int count = map.getOrDefault(sum, 0);
                map.put(sum, count);
            }
        }

        int mapsize = map.size();
        int[] xtfx = new int[mapsize];
        int index = 0;
        for(int i:map.values())
        {
            xtfx[index++] = i;
        }
        Arrays.sort(xtfx);
        return len - xtfx[mapsize - 2];
    }
}
