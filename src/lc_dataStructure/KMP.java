package lc_dataStructure;

public class KMP {
    public static void main(String[] args) {
        String s = "actgpactgactgpacy";
        String p = "actgpacy";
        int m = new KMP().match(s,p);
        System.out.println(m);
        System.out.println(Integer.compare(1,5));
    }
    int match(String S, String P)
    {
        //匹配找到出现的第一个位置，否则为-1
        if(S == null || P == null || S.length() == 0 || P.length() == 0)
            return 0;
        int plen = P.length(), slen = S.length();
        int pindex = 0, sindex = 0;
        int[] N = buildnext(P);
        while(sindex < slen && pindex < plen)
        {
            if(pindex < 0 || P.charAt(pindex) == S.charAt(sindex))
            {
                pindex++;
                sindex++;
            }else
            {
                pindex = N[pindex];
            }
        }
        if(pindex == plen)
            return sindex - pindex;
        else
            return 0;
    }
    int[] buildnext(String P)
    {
        //保证p长度>0
        int len = P.length();
        int[] next = new int[len];
        next[0] = -1;
        int j = 0, pre = -1;
        while(j < len-1)
        {
            if(pre < 0 || P.charAt(pre) == P.charAt(j)) {//匹配到
                j++;
                pre++;
                next[j] = pre;
            }else {//匹配不到前面找一个能匹配的
                pre = next[pre];
            }
        }
        return next;
    }
}
