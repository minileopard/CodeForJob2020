package lc_dataStructure;

import java.util.*;

public class Pro49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,Integer> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        int index = 0;
        for(String s:strs)
        {
            int[] temp = new int[26];
            for(char c:s.toCharArray())
            {
                temp[c-'a']++;
            }
            String ms = Arrays.toString(temp);
            if(map.containsKey(ms))
            {
                List<String> tl = res.get(map.get(ms));
                tl.add(s);
            }else
            {
                map.put(ms,index++);
                List<String> tl = new ArrayList<>();
                tl.add(s);
                res.add(tl);
            }
        }
        return res;
    }
    public List<List<String>> groupAnagrams1(String[] strs) {
        List<List<String>> rs = new ArrayList<List<String>>();
        Map<String, List<String>> mapping = new HashMap<String, List<String>>();

        for (String str : strs) {

            char[] letters = str.toCharArray();
            Arrays.sort(letters);
            String sortStr = new String(letters);

            List<String> out = mapping.get(sortStr);
            if (null == out) {
                out = new ArrayList<String>();
                rs.add(out);
                mapping.put(sortStr, out);
            }

            out.add(str);
        }
        return rs;
    }
}
