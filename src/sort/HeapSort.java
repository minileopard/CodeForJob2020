package sort;
import java.util.Arrays;

/**
 * Created by chengxiao on 2016/12/17.
 * ������demo
 */
public class HeapSort {
    public static void main(String []args){
        int []arr = {1,7,8,4,3,6,5,1,2};
        
        sort(arr, true);
        System.out.println(Arrays.toString(arr));
    }
    public static void sort(int []arr, boolean asc){
    	//asc�����������ƴ󶥶ѻ���С���ѣ���������߽���
        //1.�����󶥶�
        for(int i=arr.length/2-1;i>=0;i--){
            //�ӵ�һ����Ҷ�ӽ��������ϣ�������������ṹ
            adjustHeap(arr,i,arr.length, asc);
        }
        //2.�����ѽṹ+�����Ѷ�Ԫ����ĩβԪ��
        for(int j=arr.length-1;j>0;j--){
            swap(arr,0,j);//���Ѷ�Ԫ����ĩβԪ�ؽ��н���
            adjustHeap(arr,0,j, asc);//���¶Զѽ��е���
        }

    }
    //������Ϊ����/С���ѣ�
    public static void adjustHeap(int []arr,int i,int length, boolean minheap){
        int temp = arr[i];//��ȡ����ǰԪ��i
        //��һ��ѭ����ȷ����ǰ�ڵ�ĸ��ڵ������ֵ
        //�����ѭ����ȷ����ǰ�ڵ��޸�֮�����ĺ��ӻ��ܱ�֤�Ǵ󶥶ѣ���Ϊ��k����������ֻ��Ӱ��k
        for(int k=i*2+1;k<length;k=k*2+1){//��i�������ӽ�㿪ʼ��Ҳ����2i+1����ʼ
            if(k+1<length && arr[k]>arr[k+1] ^ minheap){//������ӽ��С�����ӽ�㣬kָ�����ӽ��
                k++;
            }
            if(arr[k] < temp ^ minheap){//����ӽڵ���ڸ��ڵ㣬���ӽڵ�ֵ�������ڵ㣨���ý��н�����
                arr[i] = arr[k];
                i = k;//��¼���Ǵ��ĸ��ڵ㽻����ֵ
            }else{
                break;
            }
        }
        arr[i] = temp;//�����ڵ��ֵ�����ӽڵ㣬���߸����Լ�
    }
    public static void swap(int []arr,int a ,int b){
        int temp=arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}