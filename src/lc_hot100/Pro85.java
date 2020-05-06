package lc_hot100;

public class Pro85 {
    public static void main(String[] args) {
        char[][] matrix = {
                {'1', '0', '1', '1', '1'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        System.out.println(new Pro85().maximalRectangle(matrix));
    }
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0)
            return 0;
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == '1')
                {
                    max = Math.max(max, max(matrix, i, j));
                }
            }
        }
        return max;
    }
    public int max(char[][] matrix, int row, int col)
    {
        int colindex = matrix[0].length - 1, max = 0;
        for (int i = row; i < matrix.length; i++) {
            if(matrix[i][col] == '0')
                break;
            for (int j = col; j <= colindex; j++) {
                if(matrix[i][j] == '1')
                {
                    max = Math.max(max, (i - row + 1) * (j - col + 1));
                }else
                {
                    colindex = j - 1;
                    break;
                }
            }
        }
        return max;
    }
}
