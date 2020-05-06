package springRecruit;

import java.util.Scanner;

public class Mar_29_bd_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		int result = Mingbs(n, n -1) - Maxgys(n, n-1);
		
		if(n == 1)
		{
			System.out.println(0);
			return;
		}
		for(int i = n; i >= 1; i--)
		{
			for(int j = i - 1; j >= 1; j--)
			{
				int cz = Mingbs(i, j) - Maxgys(i, j);
				result = Math.max(result, cz);
			}
		}
		System.out.println(result);
	}
	public static int Maxgys(int a, int b)
	{
		int temp = 0;
		while(b!=0)
		{
			temp = a % b;
			a = b;
			b = temp;
		}
		return a;
	}
	
	public static int Mingbs(int a, int b)
	{
		int temp = a * b;
		return temp / (Maxgys(a,b));
	}

}
