package sort;
class Node{
    int val;
    Node next;
    Node(int v){val = v;}
    Node(){}
}
public class LinkQuickSort {
    public static void main(String[] args) {
        int[] nums = {9,8,2,7,6,4,5,3,1};
        Node head = new Node(nums[0]);
        Node cur = head;
        for (int i = 1; i < nums.length; i++) {
            Node temp = new Node(nums[i]);
            cur.next = temp;
            cur = temp;
        }
        Node pre = new Node();
        pre.next = head;
        ListQuickSort(pre,head,null);
        //sort(head, null);
        pre = pre.next;
        while(pre!=null)
        {
            System.out.print(pre.val + " ");
            pre = pre.next;
        }
    }
    static void ListQuickSort(Node pHeadPrev, Node pHead, Node pTail) {
        // 处理过程不涉及 pHeadPrev 和 pTail
        if (pHead == pTail || pHead.next == pTail)
            return;
        Node pMid = Partation(pHeadPrev, pHead, pTail);
        ListQuickSort(pHeadPrev, pHeadPrev.next, pMid);
        ListQuickSort(pMid, pMid.next, pTail);
    };

    static Node Partation(Node pHeadPrev, Node pHead, Node pTail) {
//        int key = pHead.val; // 选第一个节点为基元
//        Node nodeL = new Node(0), nodeR = new Node(0);
//        Node pLeftPrev = nodeL; // 小于基元的链表
//        Node pRightPrev = nodeR; // 大于等于基元的链表
//        for (Node pNode = pHead.next; pNode != pTail; pNode = pNode.next) {
//            if (pNode.val < key) {
//                pLeftPrev.next = pNode;
//                pLeftPrev = pNode;
//            } else {
//                pRightPrev.next = pNode;
//                pRightPrev = pNode;
//            }
//        }
//        pRightPrev.next = pTail; // 保证子链表继续和后面的相连
//        pLeftPrev.next = pHead; // 基元节点链接
//        pHead.next = nodeR.next;
//        pHeadPrev.next = nodeL.next; // 链表头节点
//        return pHead;
        Node cur = pHead.next;
        while(cur!=pTail)
        {
            if(cur.val < pHead.val)//小于的插入到前面来
            {
                pHead.next = cur.next;
                cur.next = pHeadPrev.next;
                pHeadPrev.next = cur;
                cur = pHead.next;
            }else//大于的继续不用管
            {
                pHead = cur;
                cur = cur.next;
            }
        }
        return pHead;
    }


    public static void sort(Node head, Node tail)
    {
        if(head!=tail)
        {
            Node mid = partition2(head, tail);
            sort(mid.next,tail);
            sort(head,mid);
        }
    }
    public static Node partition(Node head, Node tail)
    {
        if(head == tail)
            return head;
        Node pre = new Node();
        pre.next = head;
        Node pcur = head;
        Node cur = head.next;
        while(cur!=tail)
        {
            if(cur.val < head.val)
            {
                pcur.next = cur.next;
                cur.next = pre.next;
                pre.next = cur;
                cur = pcur.next;
            }else
            {
                pcur = cur;
                cur = cur.next;
            }
        }
//        pre = null;
        return pre.next;
    }
    static Node partition2(Node begin, Node end)
    {
        if(begin == end)
            return begin;
        int key = begin.val;
        Node pNode = begin;
        Node qNode = begin.next;
        while(qNode != end)
        {
            if(qNode.val < key)
            {
                pNode = pNode.next;
                int tempKey = pNode.val;
                pNode.val = qNode.val;
                qNode.val = tempKey;
            }
            qNode = qNode.next;
        }
        int temp = begin.val;
        begin.val = pNode.val;
        pNode.val = temp;
        return pNode;
    }
}
//https://blog.csdn.net/quzhongxin/article/details/48087685#3-%E5%BF%AB%E9%80%9F%E6%8E%92%E5%BA%8F%E6%94%B9%E5%8F%98%E8%8A%82%E7%82%B9%E5%80%BC