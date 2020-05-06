package companyexercise;

import java.util.PriorityQueue;
import java.util.Scanner;

public class al_3_30_1 {
/*
https://blog.csdn.net/weixin_43918473/article/details/105270231
输入：
3 3 100
100 200 400
输出：
925
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), m = sc.nextInt(), k = sc.nextInt();
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>((o1, o2) -> (o2 - o1));//递增队列
		for(int i = 0; i < n; i++)
		{
			queue.add(sc.nextInt());
		}
		sc.close();
//		while(!queue.isEmpty())
//		{
//			System.out.println(queue.poll());
//		}
		//
		for(int i = 0; i < m; i++)
		{
			//增加k, 最大的除以2
			int max = (queue.poll() + k) >> 1;
			int[] temp = new int[n];
			temp[0] = max;
			for(int j = 1; j < n; j++)
			{
				temp[j] = queue.poll() + k;
			}
			for(int j = 0; j < n; j++)
			{
				queue.add(temp[j]);
				System.out.print(temp[j] + " ");
			}
			System.out.println();
		}
		int sum = 0;
		while(!queue.isEmpty())
		{
			sum += queue.poll();
		}
		System.out.println(sum);
	}

}
