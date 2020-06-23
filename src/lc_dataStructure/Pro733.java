package lc_dataStructure;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Pro733 {
    public static void main(String[] args) {
        Pro733 p = new Pro733();
        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        p.floodFill(image,1,1,2);
        for(int[] temp:image)
        {
            System.out.println(Arrays.toString(temp));
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int rowLen = image.length;
        if(rowLen == 0)
            return image;
        int colLen = image[0].length;
        boolean[][] flag = new boolean[rowLen][colLen];
        int color = image[sr][sc];
        int[][] move = {{0,1},{0,-1},{1,0},{-1,0}};
        Queue<int[]> list = new LinkedList<>();
        int[] coor = new int[2];
        coor[0] = sr;
        coor[1] = sc;
        flag[sr][sc] = true;
        list.offer(coor);
        while(!list.isEmpty())
        {
            int[] temp = list.poll();
            int xcache = temp[0];
            int ycache = temp[1];
            image[xcache][ycache] = newColor;
            for(int[] mo:move)
            {
                int x = temp[0] + mo[0];
                int y = temp[1] + mo[1];
                if(x < 0 || x >= rowLen || y < 0 || y >= colLen || flag[x][y] ||  image[x][y] != color)
                    continue;
                temp[0] = x;
                temp[1] = y;
                list.offer(temp.clone());
                flag[x][y] = true;
                temp[0] = xcache;
                temp[1] = ycache;
            }
        }
        return image;
    }
}
