package companytest;
/*
阿里面试中的代码测评
1.写一个你最熟悉的排序算法
2.实现一个简单的hashmap 要求有基本的数据结构，和简单的put get 方法实现
 */

public class April27_al_1 {
    class Node{
        int key;
        int value;
        Node next;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    class hashmap{
        int size = 16;
        Node[] list = new Node[size];
        public int get(int key)
        {
            int hashcode = Integer.hashCode(key);
            return 0;
        }
        public void put(int key, int value)
        {

        }
    }

    public static void main(String[] args) {
        int n = 16;
        int hashcode = Integer.hashCode(27);
        int index = hashcode & (n - 1);

    }
}
