package springRecruit;

import java.util.Scanner;

public class Mar26_2 {
	public static int mincount = Integer.MAX_VALUE;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int m, n;
		m = sc.nextInt();
		n = sc.nextInt();
		char[][] mg = new char[m][n];
		for(int i = 0; i < m; i++)
		{
			String line = sc.next();
			for(int j = 0; j < n; j++)
				mg[i][j] = line.charAt(j);
		}
		sc.close();
		boolean[][] flag = new boolean[m][n];
		for(int i = 0; i < m; i++)
		{
			for(int j = 0; j < n; j++)
			{
				if(mg[i][j] == 'S')
				{
					dfs(flag, mg, i, j, m, n, 0, 0);
					break;
				}
			}
		}
		System.out.println(mincount);
	}
	static void dfs(boolean[][] flag, char[][] mg, int row, int col, int m, int n, int count, int fly)
	{
		if(fly > 5)
			return;
		if(row >= m || row < 0 || col >= n || col < 0 || flag[row][col])
		{
			return;
		}
		else if(mg[row][col] == 'E')
		{
			mincount = Math.min(count, mincount);
			System.out.println("find one way");
			return;
		}
		else if(mg[row][col] == '#')
		{
			return;
		}
		flag[row][col] = true;
		dfs(flag, mg, row - 1, col, m, n, count + 1, fly);
		dfs(flag, mg, row + 1, col, m, n, count + 1, fly);
		dfs(flag, mg, row, col - 1, m, n, count + 1, fly);
		dfs(flag, mg, row, col + 1, m, n, count + 1, fly);
		dfs(flag, mg, m - row - 1, n - col - 1, m, n, count + 1, fly + 1);
		flag[row][col] = false;//»ØËÝ
	}
}
