package springRecruit;

import java.util.LinkedList;
import java.util.Scanner;

public class Mar26_mt_3 {
	public static int num = 998244353;
	public static int count = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N;
		N = sc.nextInt();
		LinkedList<Integer> l = new LinkedList<Integer>();
		for(int i = 0; i < N; i++)
		{
			l.add(sc.nextInt());
		}
		sc.close();
		
		if(IsIntesting(l))
		{
			count++;
			if(count >= num)
				count %= num;
		}
		dfs(l, 1, N);
		System.out.println(count + N);
	}
	public static void dfs(LinkedList<Integer> l, int k, int N)
	{
		if(k >= N - 1)
			return;
		//移除1个元素，判断该序列是不是有趣的
		for(int i = 0; i < l.size(); i++)
		{
			int tempnum = l.get(i);
			l.remove(i);
			if(IsIntesting(l))
			{
				count++;
				if(count >= num)
					count %= num;
			}
				
			dfs(l, k + 1, N);
			l.add(i, tempnum);
		}
	}
	
	public static boolean IsIntesting(LinkedList<Integer> l)
	{
		for(int i = 1; i <= l.size(); i++)
		{
			if(l.get(i - 1) % i != 0)
				return false;
		}
		return true;
	}
	
}
