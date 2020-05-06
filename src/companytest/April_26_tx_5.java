package companytest;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class April_26_tx_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(n--!=0)
        {
            long x = sc.nextLong();
            int k = sc.nextInt();
            int cs = (int)(Math.log10(x)/Math.log10(2))+ 1;
            System.out.println(cs+ "  cs");
            if(cs <= k)
            {
                System.out.println("-1");
                continue;
            }
            for(int i = 1; i <= cs - k; i++)
            {
                x = x >> 1;
            }
            System.out.println(x);
        }
    }
}
