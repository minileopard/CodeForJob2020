package others;

import java.util.*;

public class mytest {
    public static void main(String[] args) {
        Integer i = null;
        List<Integer> list = new ArrayList<>(5);
        list.add(null);
        System.out.println(Arrays.toString((Integer[])(list.toArray(new Integer[list.size()]))));
    }
}
