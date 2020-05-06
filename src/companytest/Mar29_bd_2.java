package springRecruit;

import java.util.Scanner;


public class Mar29_bd_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] nums = new long[n];
        for(int i = 0; i < n; i++){
            nums[i] = Long.parseLong(sc.next());
        }
        sc.close();
        
        long count = 0;
        if(n == 0)
        {
        	System.out.println(0);
        	return;
        }
        int maxindex = findMaxIndex(nums);
        count = nums[maxindex] / n;
        
        while(true)
        {
        	maxindex = findMaxIndex(nums);
        	if(nums[maxindex] < n)
        	{
        		break;
        	}
        	nums[maxindex] -= n;
        	for(int i = 0; i < n; i++)
        	{
        		if(i != maxindex)
        		{
        			nums[i] += 1;
        		}
        	}
        	count ++;
        }
        System.out.println(count);
	}
	public static int findMaxIndex(long[] nums)
	{
		long max = nums[0];
		int maxindex = 0;
		for(int i = 1; i < nums.length; i++)
		{
			if(nums[i] > max)
			{
				maxindex = i;
				max = nums[i];
			}
		}
		return maxindex;
	}
}
