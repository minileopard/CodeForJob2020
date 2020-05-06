package companyexercise;
import java.lang.StringBuilder;

import java.util.Scanner;

public class zj_Ques1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		while(N > 0)
		{
			StringBuilder s = new StringBuilder(sc.next());
	        int count_left = 1, count_right = 0;
	        if(s.length() < 1)
	        	continue;
	        for(int i = 1; i < s.length(); i++)
	        {
	            if(s.charAt(i) == s.charAt(i-1))
	            {
	                if(count_left == 1 && count_right == 0)//AA
	                {
	                    count_left++;
	                }else if(count_left == 2 && count_right == 1)//AABB
	                {
	                    s.deleteCharAt(i);
	                    i--;//保证下一个没问题
	                    count_left = 2;
	                    count_right = 1;
	                }else if(count_left == 2 && count_right == 0)//AAA
	                {
	                    s.deleteCharAt(i);
	                    i--;
	                }
	            }else if(count_left == 2 && count_right == 0)//AAB..
	            {
	                count_right = 1;
	            }else if(count_left == 2 && count_right == 1)//AABC
	            {
	            	count_left = 1;
	                count_right = 0;
	            }
	            else //AB或者AABC
	            {
	                count_left = 1;
	                count_right = 0;
	            }
	        }
	        System.out.println(s.toString());
	        N--;
		}
	}

}
