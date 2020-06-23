package lc_company;

public class Pro151_zj {
    public static void main(String[] args) {
        Pro151_zj p = new Pro151_zj();
        String s = " ";
        System.out.println(p.reverseWords(s));
    }
    public String reverseWords(String s) {
        String[] res = s.split(" ");
        int len = res.length;
        StringBuilder sb = new StringBuilder();
        for (int i = len - 1; i >= 0; i--) {
            if(res[i].equals("")||res[i].equals(" "))
            {
                continue;
            }
            sb.append(res[i] + " ");
        }
        if(sb.length() >= 1)
            sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
