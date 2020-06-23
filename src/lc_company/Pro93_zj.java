package lc_company;

import java.util.ArrayList;
import java.util.List;

public class Pro93_zj {
    public static void main(String[] args) {
        Pro93_zj p = new Pro93_zj();
        String s = "010010";
        System.out.println(p.restoreIpAddresses(s).toString());
    }
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        int len = s.length();
        if(len < 4 || len > 12)
            return res;
        StringBuilder sb = new StringBuilder();
        dfs(res, sb, len, 3, 0, s);
        return res;
    }
    public void dfs(List<String> res, StringBuilder sb, int len, int point, int index, String s)
    {
        if(index == len) {
            sb.deleteCharAt(sb.length() - 1);
            res.add(sb.toString());
            sb.setLength(0);
            return;
        }
        for (int i = 0; i < 3; i++) {
            int tempindex = index + i + 1;
            StringBuilder tsb = new StringBuilder(sb);
            if(len - tempindex > point * 3 || len - tempindex < point)
                continue;
            String temp = s.substring(index, tempindex);
            if(temp.startsWith("0") && !temp.equals("0"))
                continue;
            int ti = Integer.parseInt(temp);
            if(ti >= 0 && ti <= 255)
                tsb.append(temp + ".");
            else
            {
                continue;
            }
            dfs(res, tsb, len, point - 1, tempindex, s);
        }
    }
}
