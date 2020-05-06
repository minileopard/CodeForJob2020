package springRecruit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class April12_ks_3 {
	public static ArrayList<int[]> list = new ArrayList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {8, 9, 7};
		int[] b = {5, 8, 3};
		int[] res = WaitInLine(a, b);
		for(int i : res)
			System.out.print(i + " ");
		System.out.println();
	}
	public static int[] WaitInLine (int[] a, int[] b) {
		int len = a.length;
		ArrayList<int[]> arr = new ArrayList<int[]>();
		for(int i = 0; i < len; i++)
		{
			int[] temp = new int[2];
			temp[0] = a[i] - b[i];
			temp[1] = i + 1;
			arr.add(temp);
		}
		Collections.sort(arr, new Comparator<int[]>(){

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o2[0] - o1[0];
			}
			
		});
		int[] res = new int[len];
		for(int i = 0; i < len; i++)
		{
			res[i] = arr.get(i)[1];
		}
		cal(res, a, b);
		return res;
//		int[] res = new int[len];
//		for(int i = 0; i < len; i++)
//		{
//			res[i] = i + 1;
//		}
//		dfs(res, 0);
//		System.out.println(list.size());
//		
//		int min = Integer.MAX_VALUE;
//		int index = 0;
//		for(int i = 0; i < list.size(); i++)
//		{
//			for(int li : list.get(i))
//				System.out.print(li + " ");
//			System.out.println();
//			int temp = cal(list.get(i), a, b);
//			if(min > temp)
//				index = i;
//		}
//		
//		
//		return list.get(index);
        // write code here
    }
	public static int cal(int[] res, int[] a, int[] b)
	{
		int sum = 0;
		int len = a.length;
		for(int i = 1; i <= len; i++)
		{
			sum += a[res[i - 1] - 1] * (i - 1) + b[res[i - 1] - 1] * (len - i);
		}
		System.out.println(sum);
		return sum;
	}
	public static void dfs(int[] array, int begin)
	{
		int len = array.length;
		if(begin == len)
			list.add(array.clone());
		for(int i = begin; i < len; i++)
		{
			swap(array, begin, i);
			dfs(array, begin + 1);
			swap(array, begin, i);
		}
	}
	public static void swap(int[] arr, int i, int j)
	{
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
