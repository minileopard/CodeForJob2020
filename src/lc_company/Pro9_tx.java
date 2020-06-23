package lc_company;

public class Pro9_tx {
    public boolean isPalindrome(int x) {
        if(x < 0)
            return false;
        String s = new Integer(x).toString();
        int len = s.length();
        if(len == 1)
            return true;
        int l = 0, r = len - 1;
        while(l <= r && s.charAt(l) == s.charAt(r))
        {
            l++;
            r--;
        }
        if(l >= r)
            return true;
        else
            return false;
    }
}
