package companytest;

import java.util.Scanner;

public class mt829_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String s = sc.next();
        boolean fm = false, ft = false;
        int headEnd = 0, tailS = N - 1;
        for (int i = 0; i < N; i++) {
            if(s.charAt(i) == 'M')
            {
                fm = true;
            }
            if(s.charAt(i) == 'T' && fm)
            {
                headEnd = i;
                break;
            }
        }
        for (int i = N - 1; i >= 0; i--) {
            if(s.charAt(i) == 'T')
            {
                ft = true;
            }
            if(s.charAt(i) == 'M' && ft)
            {
                tailS = i;
                break;
            }
        }
        headEnd++;
        if(headEnd < N && headEnd < tailS)
        {
            System.out.println(s.substring(headEnd,tailS));
        }else{
            System.out.println("");
        }
    }
}
