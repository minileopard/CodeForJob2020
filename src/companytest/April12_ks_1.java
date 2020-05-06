package springRecruit;

import java.util.Scanner;
import java.util.Stack;

public class April12_ks_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		sc.close();
		int match = 0, left = 0, right = 0;
		Stack<Character> stack = new Stack<>();
		for(char c : s.toCharArray())
		{
			if(c == '(')
			{
				stack.push(c);
				left++;
			}else if(c == ')')
			{
				if(stack.isEmpty())
				{
					stack.push(c);
					right++;
					continue;
				}
				char top = stack.peek();
				if(top == '(')
				{
					match++;
					stack.pop();
					left--;
				}else
				{
					stack.push(c);
					right++;
				}
			}
		}
		System.out.println(match + " " + left + " " + right);
		
	}

}
