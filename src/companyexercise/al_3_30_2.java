package companyexercise;

import java.util.Scanner;

/*
 ‰»Î£∫
3
1 2 3
 ‰≥ˆ£∫
2.333333
*/
public class al_3_30_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] nums = new int[n];
		for(int i = 0; i < n; i++)
		{
			nums[i] = sc.nextInt();
		}
		//
		int sum = 0, count = 0;
		for(int sublen = 1; sublen <= n; sublen++)
		{
//			System.out.println("sublen" + sublen);
			for(int i = 0; i <= n - sublen; i++)
			{
//				System.out.print("Startindex " + i + " ");
				int max  = 0;
				count++;
				for(int j = i; j < i + sublen; j++)
				{
					if(nums[j] > max)
						max = nums[j];
				}
				sum += max;
//				System.out.println("max:" + max);
			}
			
		}
		double res = sum / (double)count;
		System.out.println(res);
	}

}
