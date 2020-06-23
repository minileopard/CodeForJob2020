package lc_company;

public class Pro42_tx {
    public static void main(String[] args) {
        String num1 = "9", num2 = "99";
        Pro42_tx p = new Pro42_tx();
        String res = p.multiply(num1, num2);
        System.out.println(res);
    }
    public String multiply(String num1, String num2) {
        //有一个为0
        assert(num1) != null;
        assert(num2) != null;
        if(num1.equals("0")||num2.equals("0"))
            return "0";
//        if(num1.length() < num2.length())
//        {
//            String t = num1;
//            num1 = num2;
//            num2 = t;
//        }
        StringBuilder sb = new StringBuilder();
        //先求一行行的乘积
        StringBuilder[] lines = new StringBuilder[num2.length()];
        StringBuilder lastzero = new StringBuilder();
        int maxlen = 0;
        for(int i = num2.length() - 1; i >= 0 ; i--)
        {
            lines[i] = new StringBuilder();
            lines[i].append(lastzero);
            lastzero.append('0');
            int carry = 0;
            int top = num2.charAt(i) - '0';
            for(int j = num1.length() - 1; j >= 0; j--)
            {
                int down = num1.charAt(j) - '0';
                carry = top * down + carry;
                lines[i].append((char)((carry % 10) + '0'));
                carry = carry / 10;
            }
            if(carry!= 0)
                lines[i].append((char)(carry + '0'));
            maxlen = Math.max(maxlen, lines[i].length());
        }
        //累加起来
        int carry = 0;
        for (int i = 0; i < maxlen; i++) {
            int sum = carry;
            for(int j = 0; j < lines.length; j++)
            {
                if(i < lines[j].length())
                {
                    sum += lines[j].charAt(i) - '0';
                }
            }
            sb.insert(0, (char)(sum % 10 + '0'));
            carry = sum / 10;
            if(i == maxlen - 1 && carry != 0)
                sb.insert(0, (char)(carry + '0'));
        }
        return sb.toString();
    }
}
