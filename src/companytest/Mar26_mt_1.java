package springRecruit;

import java.util.Scanner;

public class Mar26_mt_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = 9;
		String s1;
		int[] s2 = new int[N];
		s1 = sc.next();
		for(int i = 0; i < N; i++)
		{
			s2[i] = sc.nextInt();
		}
		sc.close();
		
		
		int i = 0, j = 0;
		if(s1.length() == 0)
			System.out.println();
		StringBuilder ss = new StringBuilder(s1);
		if(s1.charAt(0) == '-')
			i = 1;
		for( ; i < s1.length() && j < s2.length; i++, j++)
		{
			ss.setCharAt(i, (char) ('0' + s2[j]));
		}
		long x = Integer.parseInt(ss.toString());
		System.out.println(x);
		System.out.println(ss);
	}
	
}
