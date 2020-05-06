package lc_hot100;

public class Pro338 {
    public static void main(String[] args) {
        int[] res = new Pro338().countBits(31);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
    }
    public int[] countBits(int num) {
        if(num <= 0)
            return new int[1];
        int[] res = new int[num + 1];
        res[0] = 0;
        res[1] = 1;
        for(int i = 2; i <= num; i++)
        {
            int zs = (int)(Math.log(i) / Math.log(2));
            int py = i - (int)Math.pow(2, zs);
            res[i] = res[py] + 1;
        }
        return res;
    }
}
