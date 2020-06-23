package lc_company;
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class Pro142_tx {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
//        n4.next = n4;
        Pro142_tx p = new Pro142_tx();
        ListNode res = p.detectCycle(n1);
        if(res == null)
            System.out.println("No cycle");
        else
            System.out.println(res.val);
    }
    public ListNode detectCycle(ListNode head) {
        if(head == null)
            return head;
        //找到交点
        ListNode fast = head, slow = head;
        boolean flag = false;
        while(fast!=null && fast.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                flag = true;
                break;
            }
        }
        if(!flag)
            return null;
        //找到入口节点
        while(head!=slow)
        {
            head = head.next;
            slow = slow.next;
        }
        return head;
    }
}
