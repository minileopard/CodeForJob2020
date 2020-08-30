package companyexercise;

import java.util.Stack;
//使用常数空间来实现栈的排序
public class stackSort {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        int[] nums = {1,5,7,2,3,9,8,4};
        for(int i:nums)
            s.push(i);
        sortStack(s);
        while(!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
    }

    static void sortStack(Stack<Integer> st){
        if (st.size() == 0)
            return;

        int top = st.pop();

        sortStack(st);

        if (st.size() == 0)
        {
            st.push(top);
            return;
        }
        int top2 = st.pop();

        if(top>top2){
            st.push(top);
            sortStack(st);
            st.push(top2);
        }
        else{
            st.push(top2);
            st.push(top);
        }
    }

}
