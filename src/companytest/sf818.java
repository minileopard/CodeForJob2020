package companytest;

import java.util.Arrays;
import java.util.Scanner;

public class sf818 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] width = new int[n];
        for (int i = 0; i < n; i++) {
            width[i] = sc.nextInt();
        }
        int[][] budget = new int[m][2];
        for (int i = 0; i < m; i++) {
            budget[i][0] = sc.nextInt();
            budget[i][1] = sc.nextInt();
        }
        Arrays.sort(budget,(o1,o2)->(o1[0]-o2[0]));
        Arrays.sort(width);
        int sum = 0;
        boolean[] flag = new boolean[m];
        for (int i = 0; i < n; i++) {
            int max = 0;
            int index = -1;
            for (int j = 0; j < m; j++) {
                if(budget[j][0] > width[i])
                    break;
                if(!flag[j])
                {
                    if(max < budget[j][1])
                    {
                        max = budget[j][1];
                        index = j;
                    }
                }
            }
            if(index > -1)
                flag[index] = true;
            sum += max;
        }
        System.out.println(sum);
    }
}
/*
3 4
1 2 3
2 1
3 2
3 3
1 1

3 4
1 2 3
4 1
4 2
4 3
4 1
 */