package lc_dataStructure;

import lc_hot100.Pro739;

import java.util.Arrays;

public class Pro498 {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{4,5,6,7},{7,8,9,8}};
        int[] res = new Pro498().findDiagonalOrder(matrix);
        System.out.println(Arrays.toString(res));
    }
    public int[] findDiagonalOrder(int[][] matrix) {
        int rowlen = matrix.length;
        if(rowlen == 0)
            return new int[0];
        int collen = matrix[0].length;
        int reslen = rowlen * collen;
        int[] res = new int[reslen];
        int[][] move = {{-1,1},{1,-1},{0,1},{1,0}};
        int movedir = 0;
        int mr = move[0][0], mc = move[0][1], pr = 0, pc = 0;
        res[0] = matrix[0][0];
        for(int i = 1; i < reslen; )
        {
            int tr = pr + mr;
            int tc = pc + mc;
            if(tr < 0 || tr >= rowlen || tc < 0 || tc >= collen)
            {
                int ts = 2, count = 2;
                if(movedir == 1)
                    ts = 3;
                while(count-- > 0)
                {
                    int ttr = pr + move[ts][0];
                    int ttc = pc + move[ts][1];
                    if(!(ttr < 0 || ttr >= rowlen || ttc < 0 || ttc >= collen))
                    {
                        mr = move[ts][0];
                        mc = move[ts][1];
                        break;
                    }
                    ts = ((ts + 1) % 2) + 2;
                }
                movedir = (movedir + 1) % 2;
            }else
            {
                res[i++] = matrix[tr][tc];
                pr = tr;
                pc = tc;
                mr = move[movedir][0];
                mc = move[movedir][1];
            }
        }
        return res;
    }
}
