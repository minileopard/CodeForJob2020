package companytest;

import java.util.Scanner;

public class April17_al_1 {
/*
3 3
1 1 1
1 2
2 3
1 3

4 3
10 2 3 4
1 4
2 3
3 4
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), q = sc.nextInt();
		int[] time = new int[n];
		int[][] ste = new int[n][2];
		for(int i = 0; i < n; i++)
		{
			time[i] = sc.nextInt();
		}
		for(int i = 0; i < q; i++)
		{
			ste[i][0] = sc.nextInt() - 1;
			ste[i][1] = sc.nextInt() - 1;
		}
		sc.close();
		//0：走一条路的时间，1：走一条路的条数
		long[][] twotime = new long[q][4];
		for(int i = 0; i < q; i++)
		{
			int s = ste[i][0], e = ste[i][1];
			//将起点变成小的
			int temp = s;
			s = Math.min(s, e);
			e = Math.max(temp, e);
//			System.out.println(s + " " + e);
			//求从小到大走
			int sum = 0,count = 0;
			for(int j = s; j < e; j++)
			{
				sum += time[j];
				//System.out.println("s->e" + j);
				count++;
			}
			twotime[i][0] = sum;
			twotime[i][1] = count;
			//从大到小走
			sum = 0;
			count = 0;
			for(int j = e; j != s; )
			{
				//System.out.println("e->s" + j);
				sum += time[j];
				count++;
				j++;
				j = j % n;
			}
			twotime[i][2] = sum;
			twotime[i][3] = count;
			System.out.println(twotime[i][0] + " " + twotime[i][1] + " " + twotime[i][2] + " " + twotime[i][3]);
		}
		//求概率，小的路径中被破坏一条
		for(int i = 0; i < q; i++)
		{
			long min = 0;
			if(twotime[i][0] > twotime[i][2])
			{
				min = twotime[i][3];
			}else
			{
				min = twotime[i][1];
			}
			System.out.println(min + "/" + n);
		}
		
	}

}
