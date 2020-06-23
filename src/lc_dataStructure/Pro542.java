package lc_dataStructure;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Pro542 {
    public static void main(String[] args) {
        Pro542 p = new Pro542();
        int[][] matrix = {{0,1,0,1,1},{1,1,0,0,1},{0,0,0,1,0},{1,0,1,1,1},{1,0,0,0,1}};
        p.updateMatrix(matrix);
        for(int[] temp:matrix)
        {
            System.out.println(Arrays.toString(temp));
        }
    }
    public int[][] updateMatrix(int[][] matrix) {
        //每个元素都广度优先搜索
        int rowLen = matrix.length;
        if(rowLen == 0)
            return matrix;
        int colLen = matrix[0].length;
        for(int i = 0; i < rowLen; i++)
        {
            for(int j = 0; j < colLen; j++)
            {
                if(matrix[i][j] != 0)
                {
                    matrix[i][j] = getMax(matrix, i, j);
                }
            }
        }
        return matrix;
    }
    public int getMax(int[][] matrix, int row, int col)
    {
        int up = (row - 1) >= 0 ? matrix[row-1][col] : Integer.MAX_VALUE;
        int left = (col - 1) >= 0? matrix[row][col-1] : Integer.MAX_VALUE;
        up = Math.min(left, up);
        if(up == 0)
            return 1;
        Queue<int[]> list = new LinkedList<>();
        int count = -1;
        int rdmin = Integer.MAX_VALUE;
        int[] first = new int[2];
        first[0] = row;first[1] = col;
        list.offer(first);
        list.offer(null);
        while(!list.isEmpty())
        {
            int[] temp = list.poll();
            if(temp == null && list.size() >= 1)
            {
                count++;
                list.offer(null);
                continue;
            }else if(temp == null)
            {
                count++;
                continue;
            }
            int xcache = temp[0];
            int ycache = temp[1];
            if(matrix[xcache][ycache] == 0)
            {
                rdmin = Math.min(rdmin, count);
                break;
            }
            //下，右
            int x = xcache + 1;
            int y = ycache + 1;
            if(x < matrix.length)
            {
                temp[0] = x;
                list.offer(temp.clone());
                temp[0] = xcache;
            }
            if(y < matrix[0].length)
            {
                temp[1] = y;
                list.offer(temp.clone());
                temp[1] = ycache;
            }
        }
        return Math.min(up, rdmin) + 1;
        //return Math.min(recursion(matrix, row, col) - 1, up) + 1;
    }
    public int recursion(int[][] matrix, int row, int col)
    {
        if(row >= matrix.length || col >= matrix[0].length)
        {
            return Integer.MAX_VALUE;
        }else if(matrix[row][col] == 0)
        {
            return 0;
        }
        int down = recursion(matrix, row + 1, col);
        int right = recursion(matrix, row, col + 1);
        if(down == right && down == Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        else
            return Math.min(down,right) + 1;
    }
}
