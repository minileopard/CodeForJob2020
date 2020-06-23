package others;

import java.util.HashMap;
import java.util.Objects;

public class MyHashMap<K, V> {
    public final int capacity = 16;
    public Node<K, V>[] array;
    private static class Node<K,V>{
        K key;
        V value;
        Node<K, V> next;
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public MyHashMap() {
        this.array = new Node[capacity];
    }

    //目标位置为空则直接插入，目标位置非空，寻找key值相同如果有替换value如果没有直接头插
    public void put(K key, V value)
    {
        int index = getindex(key);
        Node<K, V> temp = array[index];
        Node<K, V> node = new Node<>(key, value);
        if(temp != null)
        {
            while(temp != null)
            {
                if(temp.key.equals(node.key))
                {
                    temp.value = node.value;
                    return;
                }
                temp = temp.next;
            }
            node.next = array[index];
        }
        array[index] = node;
    }
    public V get(K key)
    {
        int index = getindex(key);
        Node<K, V> temp = array[index];
        while(temp != null)
        {
            if(temp.key.equals(key))
            {
                return temp.value;
            }
            temp = temp.next;
        }
        return null;
    }
    public int getindex(K key)
    {
        int hashcode = Objects.hashCode(key);
        return hashcode & (capacity - 1);
    }

    public static void main(String[] args) {
        MyHashMap<Integer, Integer> map = new MyHashMap<>();
        map.put(1,1);
        map.put(2,2);
        map.put(3,3);
        map.put(1,4);
        System.out.println(map.get(0));
    }
}
