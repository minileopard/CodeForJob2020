package companytest;

import java.util.Scanner;

public class April11_wy_2 {
	public static int value = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		char[][] map = new char[n][n];
		for(int i = 0; i < n; i++)
		{
			String line = sc.next();
			for(int j = 0; j < n; j++)
			{
				map[i][j] = line.charAt(j);
			}
		}
		int x = sc.nextInt(), y = sc.nextInt();
		sc.close();
		
		boolean[][] flag = new boolean[n][n];
		dfs(map, flag, x, y, n);
		System.out.println(value);
		
	}
	public static void dfs(char[][] map, boolean[][] flag, int x, int y, int n)
	{
		if(x < 0 || x >= n || y < 0 || y >= n || flag[x][y] || map[x][y] == '#')
			return;
		if(map[x][y] >= '0' && map[x][y] <= '9')
		{
			value += map[x][y] - '0';
		}
		flag[x][y] = true;
		
		dfs(map, flag, x - 1, y, n);
		dfs(map, flag, x + 1, y, n);
		dfs(map, flag, x, y - 1, n);
		dfs(map, flag, x, y + 1, n);
	}

}
