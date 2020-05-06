package springRecruit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class April15_hw_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String vote = sc.next();
		sc.close();
		
		//判断数据是否正常
		for(char c : vote.toCharArray())
		{
			if(!(c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z' || c == ','))
			{
				System.out.println("error.0001");
				return;
			}
		}
		
		String[] names = vote.split(",");
		int len = names.length;
		if(len <= 0 || len >= 100)
		{
			System.out.println("error.0001");
			return;
		}
		//统计每个人票数
		HashMap<String, Integer> map = new HashMap<>();
		int maxcount = 0;
		for(String s:names)
		{
			//查看人的名字是否符合规范
			if(s.charAt(0) > 'Z' || s.charAt(0) < 'A')
			{
				System.out.println("error.0001");
				return;
			}
			for(int i = 1; i < s.length(); i++)
			{
				if(s.charAt(i) > 'z' || s.charAt(i) < 'a')
				{
					System.out.println("error.0001");
					return;
				}
			}
			int count = map.getOrDefault(s, 0) + 1;
			map.put(s, count);
			if(count > maxcount)
			{
				maxcount = count;
			}
		}
		//将票数等于最高票数的人跳出来
		ArrayList<String> list = new ArrayList<>();
		for(Entry<String, Integer> entry : map.entrySet())
		{
			if(entry.getValue() == maxcount)
			{
				list.add(entry.getKey());
				System.out.println(entry.getKey());
			}
		}
		//按照字典序排序
		Collections.sort(list);
		
		System.out.println(list.get(0));
		
	}

	/*
	 * Tom,Lily,Tom,Lucy,Lucy,Jack,Lucyz,Lucyz
	 */
}
