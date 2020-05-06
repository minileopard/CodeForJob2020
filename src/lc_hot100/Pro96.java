package lc_hot100;

public class Pro96 {
    public static void main(String[] args) {
        System.out.println(new Pro96().numTrees(4));
    }
    public int numTrees(int n) {
        if(n <= 1)
            return 1;
        int[] bp = new int[n + 1];
        bp[0] = 1;
        for(int i = 1; i <= n; i++)
        {
            int sum = 0, k = 1, j;
            int half = i >> 1;
            //两边的
            for( ;k <= half; k++)
            {
                j = i - k;
                sum += bp[j] * bp[k -1];
            }
            sum = sum << 1;
            //中间的
            if((i & 1) == 1)
            {
                j = i - k;
                sum += bp[j] * bp[k -1];
            }
            bp[i] = sum;

        }
        return bp[n];
    }
}
