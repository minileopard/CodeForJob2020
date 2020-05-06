package companytest;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class April_26_tx_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(n--!=0)
        {
            int size = sc.nextInt();
            int[][] A = new int[size][2];
            int[][] B = new int[size][2];
            for(int i = 0; i < size; i++)
            {
                A[i][0] = sc.nextInt();
                A[i][1] = sc.nextInt();
            }
            for(int i = 0; i < size; i++)
            {
                B[i][0] = sc.nextInt();
                B[i][1] = sc.nextInt();
            }
            //
            double mindis2 = Double.MAX_VALUE;
            for(int i = 0; i < size; i++)
            {
                double minsum = Double.MAX_VALUE, minsumx = 0, minsumy = 0;
                for(int j = 0; j < size; j++)
                {
                    double sumx = Math.abs(A[i][0]-B[j][0]);
                    double sumy = Math.abs(A[i][1]-B[j][1]);
                    double sum =  sumx + sumy;
                    if(minsum > sum && (sumx*sumy > minsumx*minsumy))
                    {
                        minsum = sum;
                        minsumx = sumx;
                        minsumy = sumy;
                    }
                }
                double dis2 = Math.pow(minsumx, 2) + Math.pow(minsumy, 2);
                if(dis2 < mindis2)
                    mindis2 = dis2;
            }
            DecimalFormat df = new DecimalFormat("0.000");
            System.out.println(df.format(Math.sqrt(mindis2)));
        }
    }
}
