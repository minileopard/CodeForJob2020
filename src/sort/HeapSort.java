package sort;
import java.util.Arrays;

/**
 * Created by chengxiao on 2016/12/17.
 * 堆排序demo
 */
public class HeapSort {
    public static void main(String []args){
        int []arr = {1,7,8,4,3,6,5,1,2};
        
        sort(arr, true);
        System.out.println(Arrays.toString(arr));
    }
    public static void sort(int []arr, boolean asc){
    	//asc参数用来控制大顶堆还是小顶堆，即升序或者降序
        //1.构建大顶堆
        for(int i=arr.length/2-1;i>=0;i--){
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(arr,i,arr.length, asc);
        }
        //2.调整堆结构+交换堆顶元素与末尾元素
        for(int j=arr.length-1;j>0;j--){
            swap(arr,0,j);//将堆顶元素与末尾元素进行交换
            adjustHeap(arr,0,j, asc);//重新对堆进行调整
        }

    }
    //调整成为（大顶/小顶堆）
    public static void adjustHeap(int []arr,int i,int length, boolean minheap){
        int temp = arr[i];//先取出当前元素i
        //第一次循环，确保当前节点的根节点是最大值
        //后面的循环，确保当前节点修改之后他的孩子还能保证是大顶堆，因为从k交换，所以只会影响k
        for(int k=i*2+1;k<length;k=k*2+1){//从i结点的左子结点开始，也就是2i+1处开始
            if(k+1<length && arr[k]>arr[k+1] ^ minheap){//如果左子结点小于右子结点，k指向右子结点
                k++;
            }
            if(arr[k] < temp ^ minheap){//如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
                arr[i] = arr[k];
                i = k;//记录下是从哪个节点交换的值
            }else{
                break;
            }
        }
        arr[i] = temp;//将父节点的值赋给子节点，或者赋给自己
    }
    public static void swap(int []arr,int a ,int b){
        int temp=arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}