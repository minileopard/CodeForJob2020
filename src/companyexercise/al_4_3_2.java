package companyexercise;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
 https://blog.csdn.net/weixin_43918473/article/details/105286172
输入
3 3 
3 1 3
3 1 0
3 1 3
输出
3 
输出：
3 4
9 9 1 1
9 1 1 9
1 1 9 9
输出：
4 
输入：
3 4
9 9 2 3
2 1 2 1
1 9 9 1
输出：
5
输入：
5 5
1 100 100 1 1
1 100 100 100 100
1 100 1 1 1
1 1 1 100 1
100 100 100 100 1
 */
public class al_4_3_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt(), n = sc.nextInt();
		int[][] weight = new int[m][n];
		for(int i = 0; i < m; i++)
		{
			for(int j = 0; j < n; j++)
			{
				weight[i][j] = sc.nextInt();
			}
		}
		sc.close();
		
		PriorityQueue<int[]> que = new PriorityQueue<int[]>(new Comparator<int[]>(){
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[2] - o2[2];
			}
		});
		//初始化第一行
		boolean[][] flag = new boolean[m][n];
		for(int i = 0; i < 1; i++)
		{
			int[] temp = new int[3];
			temp[0] = 0;
			temp[1] = i;
			temp[2] = weight[0][i];
			que.add(temp.clone());
			flag[0][i] = true;
		}
		//广度优先搜索
		int[][] dirction = {{0,1},{0,-1},{-1,0},{1,0}};
		while(!que.isEmpty())
		{
			int[] temp = que.poll();
			if(temp[0] == m - 1 && temp[1] == n - 1)
			{
				System.out.println(temp[2]);
				return;
			}
			//四个方向搜索
			for(int i = 0; i < 4; i++)
			{
				int x = temp[0] + dirction[i][0];
				int y = temp[1] + dirction[i][1];
				//超出范围的不管,已经访问过的不管
				if(x >= m || x < 0 || y >= n || y < 0 || flag[x][y])
					continue;
				int[] tempadd = new int[3];
				tempadd[0] = x;
				tempadd[1] = y;
				tempadd[2] = temp[2] + weight[x][y];
				que.add(tempadd.clone());
				flag[x][y] = true;
			}
		}
		System.out.println("-1");
	}

}
