package companyexercise;

import java.util.Scanner;

public class zj_Ques2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N, D, count = 0, modx = 99997867;
		N = sc.nextInt();
		D = sc.nextInt();
		if(N < 3)
			return;
		int[] zb = new int[N];
		for(int i = 0; i < N; i++)
			zb[i] = sc.nextInt();
		sc.close();
		for (int i = 0,j = 0; i<N; i++){
        	//因为有三个特工嘛，所以i>=2的时候取dist[2]是第三个特工
        	//这时候j=0，dist[i]-dist[j]>D是比较最近和最远的距离
 
            while (i >= 2 && (zb[i] - zb[j]) > D)
                j++;
            //满足距离小于等于D的时候，个数加一
            int n = i - j;
            n = n * (n - 1);
            n = n >> 1;
            count += n;
            if(count >= modx)
            	count %= modx;
        }
		System.out.println(count);
	}
}
