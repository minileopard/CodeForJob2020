package lc_dataStructure;

public class Pro367 {
    public static void main(String[] args) {
        System.out.println(new Pro367().isPerfectSquare(808201));
        System.out.println(Integer.MAX_VALUE);
    }
    public boolean isPerfectSquare(int num) {
        if(num == 1)
            return true;
        int left = 2, right = 46341;
        while(left <= right)
        {
            int mid = left + ((right - left) >> 1);
            long temp = mid * mid;
            if(temp == num)
            {
                return true;
            }else if(temp > num)
            {
                right = mid - 1;
            }else
            {
                left = mid + 1;
            }
        }
        return false;
    }
}
