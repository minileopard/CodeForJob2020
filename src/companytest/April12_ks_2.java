package springRecruit;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class April12_ks_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String line = sc.next();
		sc.close();
		String[] nums = line.split(",");
		int num = Integer.parseInt(nums[0]);
		int n = Integer.parseInt(nums[1]);
		Set<Integer> result = new TreeSet<Integer>();
		while(num > 0)
		{
			int lg = (int)(Math.log(num)/Math.log(n));
			num = num - (int)Math.pow(n, lg);
			if(result.contains(lg))
			{
				System.out.println("[]");
				return;
			}else
			{
				result.add(lg);
			}
		}
		System.out.print("[");
		Iterator<Integer> it = result.iterator();
		while(it.hasNext())
		{
			int temp = it.next();
			if(it.hasNext())
				System.out.print(temp + " ");
			else
				System.out.print(temp);
		}
		System.out.println("]");
	}
	public static int[] GetPowerFactor (int R, int N) {
        // write code here
        int num = R;
		int n = N;
		Set<Integer> result = new TreeSet<Integer>();
		while(num > 0)
		{
			int lg = (int)(Math.log(num)/Math.log(n));
			num = num - (int)Math.pow(n, lg);
			if(result.contains(lg))
			{
				return new int[0];
			}else
			{
				result.add(lg);
			}
		}
		int[] res = new int[result.size()];
		Object[] temp = result.toArray();
		for(int i = 0; i < res.length; i++)
		{
			res[i] = (int)temp[i];
		}
		return res;
    }
}
