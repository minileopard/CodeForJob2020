package springRecruit;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class April15_hw_3 {
	public static boolean isR = false;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String tempss = sc.nextLine();
//		System.out.println(tempss);
		String[] t = tempss.split(" ");
		int n = Integer.parseInt(t[0]);
		int[] dy = new int[n];
		for(int i = 1; i <= n; i++)
		{
			dy[i - 1] = Integer.parseInt(t[i]);
		}
//		for(int i = 0; i < n; i++)
//		{
//			System.out.print(dy[i] + " ");
//		}
//		System.out.println("dy");
		List<ArrayList<Integer>> dygx= new ArrayList<ArrayList<Integer>>();
		for(int i = 0; i < n; i++)
		{
			String tempS = sc.nextLine();
//			System.out.print(tempS);
			//判断是否给出栈大小
			String[] temp = tempS.split(" ");
			int len = temp.length;
//			System.out.println(len + "+++"  + dy[i]);
			if(len != dy[i] + 2)
			{
				System.out.println("NA");
				return;
			}
			ArrayList<Integer> tl = new ArrayList<Integer>();
			for(int j = 0; j < len; j++)
			{
				tl.add(Integer.parseInt(temp[j]));
			}
			dygx.add(tl);
		}
		
//		System.out.println("print");
//		for(int i = 0; i < dygx.size(); i++)
//		{
//			ArrayList<Integer> temp = dygx.get(i);
//			for(int j = 0 ; j < temp.size(); j++)
//			{
//				System.out.print(temp.get(j) + " ");
//			}
//			System.out.println();
//		}
		
		//
		boolean[] flag = new boolean[n];
		int result = dfs(dygx, 0, flag);
		if(isR)
		{
			System.out.println("R");
		}else
			System.out.println("res" + result);
	}
	
	public static int dfs(List<ArrayList<Integer>> list, int index, boolean[] flag)
	{
		if(flag[index])
		{
			isR = true;
//			System.out.println("R");
			return 0;
		}
//		System.out.println("index" + index);
		int count = list.get(index).get(1);
		int len = list.get(index).size();
		if(len <= 2)
		{
			return count;
		}
		int max = 0;
		for(int i = 2; i < len; i++)
		{
			flag[index] = true;
			int temp = dfs(list, list.get(index).get(i) - 1, flag);
			flag[index] = false;
			if(temp > max)
				max = temp;
		}
//		System.out.println("count" + count);
		return count + max;
	}

}
/*
5 2 3 1 0 1
1 20 2 3
2 30 3 4 5
3 50 4
4 60
5 80 1

5 2 3 1 0 0
1 20 2 3
2 30 3 4 5
3 50 4
4 60
5 80
*/