package lc_hot100;


import java.util.HashSet;
import java.util.Set;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class Pro142 {
    public ListNode detectCycle(ListNode head) {
        if(head == null)
            return null;
        Set<ListNode> map = new HashSet<>();
        ListNode slow = head;
        boolean flag = false;
        while(slow.next!=null)
        {
            if(!map.contains(slow))
                map.add(slow);
            else
            {
                return slow;
            }
            slow = slow.next;
        }
        return null;
    }
}
