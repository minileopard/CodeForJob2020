package companyexercise;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class al_3_23_2 {
	/*
	 * 第二题要使用BFS, 据说DFS会超时
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] map = {
				{'#','S','.','.'},
				{'E','#','.','.'},
				{'#','.','.','.'},
				{'.','.','.','.'}
		};
		for(int i = 0; i < map.length; i++)
		{
			for(int j = 0; j < map[0].length; j++)
			{
				if(map[i][j] == 'S')
				{
					System.out.println(findWay(map, i, j));
					return;
				}
			}
		}
		return;
	}
	public static int findWayLength(char[][] map, int sx, int sy)
	{
		int rows = map.length;
		int cols = map[0].length;
		int flys = 5;
		boolean[][] flag = new boolean[rows][cols];
		Queue<int[]> que = new LinkedList<>();
		int[] temp = new int[2];
		temp[0] = sx;
		temp[1] = sy;
		que.add(temp.clone());
		flag[sx][sy] = true;
		temp[0] = -1;
		temp[1] = -1;
		que.add(temp.clone());
		int count = 0;
		
		while(!que.isEmpty())
		{
			int[] top = que.poll();
			int tx = top[0], ty = top[1];
			//System.out.println(tx + " " + ty);
			if(tx == -1 && ty == -1)
			{
				count++;
				que.add(temp.clone());
				continue;
			}
			if(map[tx][ty] == 'E')
			{
				//System.out.println("find");
				break;
			}
			if(tx - 1 >= 0 && map[tx - 1][ty] != '#' && !flag[tx - 1][ty]){
				top[0] = tx - 1; que.add(top.clone()); top[0] = tx; flag[tx - 1][ty] = true;}
			if(tx + 1 < rows && map[tx + 1][ty] != '#' && !flag[tx + 1][ty]){
				top[0] = tx + 1; que.add(top.clone()); top[0] = tx; flag[tx + 1][ty] = true;}
			if(ty - 1 >= 0 && map[tx][ty - 1] != '#' && !flag[tx][ty - 1]){
				top[1] = ty - 1; que.add(top.clone()); top[1] = ty; flag[tx][ty - 1] = true;}
			if(ty + 1 < cols && map[tx][ty + 1] != '#' && !flag[tx][ty + 1]){
				top[1] = ty + 1; que.add(top.clone()); top[1] = ty; flag[tx][ty + 1] = true;}
			if(flys > 0 && map[rows - 1 - tx][cols - 1 - ty] != '#' && !flag[rows - 1 - tx][cols - 1 - ty])
			{
				flys--;
				top[0] = rows - 1 - tx;
				top[1] = cols - 1 - ty;
				que.add(top);
				flag[rows - 1 - tx][cols - 1 - ty] = true;
			}
		}
		
		
		return count;
	}
	
	public static int findWay(char[][] map, int sx, int sy)
	{
		int rows = map.length;
		int cols = map[0].length;
		int flys = 5;
		boolean[][] flag = new boolean[rows][cols];
		List<int[]> que = new ArrayList<>();
		int queindex = 0;
		int[] temp = new int[4];
		temp[0] = sx;
		temp[1] = sy;
		temp[2] = -1;//前驱index没有计-1
		temp[3] = 0;//这条路径上已经有多少次对称飞行了
		que.add(temp.clone());
		flag[sx][sy] = true;

		boolean isFind = false;
		while(queindex < que.size())
		{
			int[] top = que.get(queindex).clone();
			int tx = top[0], ty = top[1];
			int countfly = top[3];
			//保存前驱节点
			top[2] = queindex;
			//System.out.println(tx + " " + ty);
			
			if(map[tx][ty] == 'E')
			{
				isFind = true;
				break;
			}
			if(tx - 1 >= 0 && map[tx - 1][ty] != '#' && !flag[tx - 1][ty]){
				top[0] = tx - 1; que.add(top.clone()); top[0] = tx; flag[tx - 1][ty] = true;}
			if(tx + 1 < rows && map[tx + 1][ty] != '#' && !flag[tx + 1][ty]){
				top[0] = tx + 1; que.add(top.clone()); top[0] = tx; flag[tx + 1][ty] = true;}
			if(ty - 1 >= 0 && map[tx][ty - 1] != '#' && !flag[tx][ty - 1]){
				top[1] = ty - 1; que.add(top.clone()); top[1] = ty; flag[tx][ty - 1] = true;}
			if(ty + 1 < cols && map[tx][ty + 1] != '#' && !flag[tx][ty + 1]){
				top[1] = ty + 1; que.add(top.clone()); top[1] = ty; flag[tx][ty + 1] = true;}
			if(countfly <= flys && map[rows - 1 - tx][cols - 1 - ty] != '#' && !flag[rows - 1 - tx][cols - 1 - ty])
			{
				top[0] = rows - 1 - tx;
				top[1] = cols - 1 - ty;
				top[3]++;
				que.add(top.clone());
				flag[rows - 1 - tx][cols - 1 - ty] = true;
			}
			queindex++;
		}
		
		int count = -1;
		if(isFind)
		{
			int front = queindex;
			while(front != -1)
			{
				System.out.println(que.get(front)[0] + " " + que.get(front)[1]);
				front = que.get(front)[2];
				count++;
			}
			
		}
		
		return count;
	}

}
