package lc_company;

import java.util.ArrayList;
import java.util.List;

public class Pro89_tx {
    public static void main(String[] args) {
        Pro89_tx p = new Pro89_tx();
        System.out.println(p.grayCode(4).toString());
    }
    public List<Integer> grayCode(int n) {
//        List<Integer> res = new ArrayList<Integer>();
//        res.add(0);
//        if(n <= 0)
//            return res;
//        res.add(1);
//        if(n == 1)
//            return res;
//        int len = (int)Math.pow(2, n);
//        int cf = 1, index = 1, count = 2;
//        while(count < len)
//        {
//            int base = (int)Math.pow(2, cf++);
//            if(count == base)
//            {
//                while(index >= 0)
//                {
//                    res.add(base + res.get(index));
//                    index--;
//                    count++;
//                    if(count >= len)
//                        break;
//                }
//                index = count - 1;
//            }
//        }
//        return res;

        List<Integer> gray = new ArrayList<Integer>();
        gray.add(0);
        for (int i = 0; i < n; i++) {
            int add = 1 << i; //
            for (int j = gray.size() - 1; j >= 0; j--) {
                gray.add(gray.get(j) + add);
            }
        }
        return gray;
    }
}
