package companytest;

import java.util.Scanner;

public class pdd_802_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = 6;
        String[] array = new String[N];
        for (int i = 0; i < N; i++) {
            array[i] = sc.nextLine();
        }
        int[][] list = new int[N][N];
        for (int i = 0; i < N; i++) {
            String line = array[i];
            for (int j = 0; j < N; j++) {
                if(line.charAt(j) == '*')
                    continue;
                boolean left = false, up = false;
                if(i - 1 >= 0 && array[i-1].charAt(j) == '#')
                    up = true;
                if(j - 1 >= 0 && array[i].charAt(j-1) =='#')
                    left = true;
                if(left == false && up == false)
                {
                    list[i][j] = 6;
                }else if(left == true && up == false)
                {
                    list[i][j] = list[i][j-1] - 1;
                }else if(left == false && up == true)
                {
                    list[i][j] = list[i-1][j] - 1;
                }else
                {
                    list[i][j] = Math.min(list[i][j-1], list[i-1][j]) - 1;
                }
            }
        }
        int res = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(list[i][j] != 0)
                {
                    res = (res * list[i][j]) % 1000000009;
                }
            }
        }
        System.out.println(res);
    }

}
