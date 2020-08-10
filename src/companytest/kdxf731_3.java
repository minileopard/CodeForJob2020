package companytest;

import java.util.Scanner;
//题目：两个矩形是否相交
//思路：相交的矩形，两个中心点间的距离小于等于AB边长一半
public class kdxf731_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] corr = new int[8];
        for (int i = 0; i < 8; i++) {
            corr[i] = sc.nextInt();
        }
        int lx = Math.abs(corr[0] - corr[2]) + Math.abs(corr[4] - corr[6]);
        int ly = Math.abs(corr[1] - corr[3]) + Math.abs(corr[5] - corr[7]);
        int zx = Math.abs(corr[0] + corr[2] - corr[4] - corr[4]);
        int zy = Math.abs(corr[1] + corr[3] - corr[5] - corr[7]);
        if(zx <= lx && zy <= ly)
            System.out.println(1);
        else
            System.out.println(0);
    }
}
