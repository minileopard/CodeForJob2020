package companyexercise;
class Node{
    int val;
    Node next;
    Node(int v){val = v;}
}
public class LinkedListSum {
    public static void main(String[] args) {
        int[] nums = {9,8,9,8};
        Node root = new Node(nums[0]);
        Node cur = root;
        for (int i = 1; i < nums.length; i++) {
            Node temp = new Node(nums[i]);
            cur.next = temp;
            cur = temp;
        }
        int carry = fun(root, 1);
        if(carry > 0)
        {
            Node pre = new Node(carry);
            pre.next = root;
            root = pre;
        }
        while(root!=null)
        {
            System.out.print(root.val+" ");
            root = root.next;
        }
    }
    public static int fun(Node root, int num)
    {
        if(root.next == null)
        {
            int temp = root.val + num;
            root.val = temp % 10;
            return temp/10;
        }
        int carry = fun(root.next, num);
        int temp = root.val + carry;
        root.val = temp % 10;
        return temp / 10;
    }
}
