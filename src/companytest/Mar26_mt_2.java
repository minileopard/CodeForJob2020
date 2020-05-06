package springRecruit;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Scanner;

public class Mar26_mt_2 {
	public static double PI = 3.141592653;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N;
		N = sc.nextInt();
		int[] rlist = new int[N];
		
		for(int i = 0; i < N; i++)
		{
			rlist[i] = sc.nextInt();
		}
		
		sc.close();
		
		if(N == 0)
		{
			System.out.println(0);
			return;
		}
		Arrays.sort(rlist);
		double sum = 0;
		int half = N >> 1;
		int i = N - 1;
		for(int j = 0;j < half && i > 0; j++)
		{
			sum += Math.pow(rlist[i], 2) - Math.pow(rlist[i - 1], 2);
			i = i - 2;
		}
		if(i == 0)
		{
			sum += Math.pow(rlist[0], 2);
		}
		sum = sum * PI;
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(5);
		System.out.println(nf.format(sum));
	}

}
