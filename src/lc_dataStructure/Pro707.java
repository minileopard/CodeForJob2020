package lc_dataStructure;
class MyLinkedList {
    class node{
        public int val;
        public node next;
        public node(){}
        public node(int v){val = v;}
    }
    node head, tail;
    /** Initialize your data structure here. */
    public MyLinkedList() {

    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        node temp = head;
        while(index-- > 0 && temp!=null)
        {
            temp = temp.next;
        }
        if(temp == null)
            return -1;
        else
            return temp.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        node temp = new node(val);
        if(tail == null && head == null)
        {
            tail = temp;
            head = temp;
        }else
        {
            temp.next = head;
            head = temp;
        }
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        node temp = new node(val);
        if(tail == null && head == null)
        {
            head = temp;
            tail = temp;
        }else
        {
            tail.next = temp;
            tail = temp;
        }
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        node temp = new node(val);
        if(tail == null && head == null)
        {
            head = temp;
            tail = temp;
        }else
        {
            node tt = head;
            if(index <= 0)
            {
                temp.next = head;
                head = temp;
            }else
            {
                while(index-- > 1 && tt!=null)
                {
                    tt = tt.next;
                }
                if(tt == null)
                {
                    return;
                }else
                {
                    if(tt.next == null)
                        tail = temp;
                    temp.next = tt.next;
                    tt.next = temp;
                }
            }
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index < 0 || head == null)
            return;
        else if(index == 0)
        {
            head = head.next;
        }else if(index > 0)
        {
            node tt = head;
            while(index-- > 1 && tt!=null)
            {
                tt = tt.next;
            }
            if(tt == null || tt.next == null)
                return;
            if(tt.next.next == null)
            {
                tail = tt;
            }
            tt.next = tt.next.next;
        }
    }
}
public class Pro707 {
    public static void main(String[] args) {
        /*
 ["addAtHead","addAtTail","addAtHead","addAtTail","addAtHead","addAtHead","get","addAtHead","get","get","addAtTail"]
[[7],[7],[9],[8],[6],[0],[5],[0],[2],[5],[4]]

         */
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(7);
        linkedList.addAtTail(7);
        linkedList.addAtHead(9);
        linkedList.addAtTail(8);
        linkedList.addAtHead(6);
        linkedList.addAtHead(0);
        int i = linkedList.get(5);
        linkedList.addAtHead(0);
        i = linkedList.get(2);
        i = linkedList.get(5);
        linkedList.addAtTail(4);
    }
}
