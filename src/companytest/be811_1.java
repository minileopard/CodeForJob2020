package companytest;

import java.util.Scanner;

public class be811_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String s = sc.next();
        int half = N / 2;
        if(N % 2 == 1)
        {
            half += 1;
        }
        int count = 0;
        for (int i = 0, j = N - 1; i < half && j >= half; i++, j--) {
            if(s.charAt(i) != s.charAt(j))
                count++;
        }
        System.out.println(count);
    }
}
