package sort;

/**
 * 
 * @author 鲍思佳
 *	快速排序
 */
public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1,5,3,6,4,8,7,2,10,9,3,6,8};
		partition(array, 0, array.length - 1 );
		for(int i:array)
			System.out.print(i + " ");
		System.out.println();
	}
	public static void partition(int[] array, int start, int end)
	{
		int mid = sort(array, start, end);
		if(mid < end)
		{
			partition(array, mid + 1, end);
		}
		if(mid > start)
		{
			partition(array, start, mid - 1);
		}
	}
	public static int sort(int[] array, int start, int end)
	{
		//选第一个数据为中间数据,小的移到左边，大的不动
		if(start == end)
			return start;
		swap(array, start, end);
		for(int i = start; i < end; i++)
		{
			if(array[i] < array[end])
			{
				swap(array, start, i);
				start++;
			}
		}
		swap(array, start, end);
		return start;
	}
	public static void swap(int[] array, int aim, int from)
	{
		int temp = array[aim];
		array[aim] = array[from];
		array[from] = temp;
	}
}
