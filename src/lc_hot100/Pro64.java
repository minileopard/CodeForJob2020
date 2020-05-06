package lc_hot100;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Pro64 {
    int minsum = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int[][] grid = {
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };
        System.out.println(new Pro64().minPathSum_solution3(grid));
    }
    //解法3，优先队列+BFS!!!求解最短路径和神器
    public int minPathSum_solution3(int[][] grid) {
        if(grid == null || grid.length < 1)
            return 0;
        int row = grid.length;
        int col = grid[0].length;
        if(row == 1 && col == 1)
            return grid[0][0];
        boolean[][] flag = new boolean[row][col];
        //优先队列存：行index，列index,路径节点权重之和，按照权重升序
        PriorityQueue<int[]> que = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        //加入第一个节点
        flag[0][0] = true;
        int[] temp = new int[3];
        temp[0] = 0;
        temp[1] = 0;
        temp[2] = grid[0][0];
        que.add(temp.clone());
        //方向缓存,右和下
        int[][] dir = {{0,1},{1,0}};
        while(!que.isEmpty())
        {
            temp = que.poll();//取出队列头，即最小的
            if(temp[0] == row - 1 && temp[1] == col - 1)
            {
                return temp[2];
            }
            for (int i = 0; i < dir.length; i++) {
                int nx = temp[0] + dir[i][0];
                int ny = temp[1] + dir[i][1];
                if(nx >= row || ny >= col || flag[nx][ny])
                {
                    continue;
                }
                int[] tt = temp.clone();
                tt[2] += grid[nx][ny];
                tt[0] = nx;
                tt[1] = ny;
                que.add(tt.clone());
                flag[tt[0]][tt[1]] = true;
            }
        }
        return 0;
    }
    //解法2，动态规划，AC
    public int minPathSum_solution2(int[][] grid) {
        if(grid == null || grid.length < 1)
            return 0;
        int row = grid.length;
        int col = grid[0].length;
        if(row == 1 && col == 1)
            return grid[0][0];
        int[][] dp = new int[row][col];
        //初始化dp数组
        int sum = 0;
        for (int i = 0; i < row; i++) {
            sum += grid[i][0];
            dp[i][0] = sum;
        }
        sum = 0;
        for (int i = 0; i < col; i++) {
            sum += grid[0][i];
            dp[0][i] = sum;
        }
        //
        for(int i = 1; i < row; i++)
        {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[row - 1][col - 1];
    }
    //解法1深度优先搜索，超时
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length < 1)
            return 0;
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] flag = new boolean[row][col];
        dfs(grid, flag, 0, 0, 0);
        return minsum;
    }
    public void dfs(int[][] grid, boolean[][] flag, int r, int l, int sum)
    {
        if(r < 0 || l < 0 || r >= grid.length || l >= grid[0].length || flag[r][l])
            return;
        flag[r][l] = true;
        sum += grid[r][l];
        if(r == grid.length - 1 && l == grid[0].length - 1)
        {
            minsum = Math.min(sum, minsum);
        }else
        {
            dfs(grid, flag, r+1, l, sum);
            dfs(grid, flag, r, l+1, sum);
        }
        flag[r][l] = false;
        sum -= grid[r][l];
    }
}
