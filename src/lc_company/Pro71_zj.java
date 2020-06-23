package lc_company;


import java.util.Stack;

public class Pro71_zj {
    public static void main(String[] args) {
        String path = "/home//foo///";
        Pro71_zj p = new Pro71_zj();
        System.out.println(p.simplifyPath(path));
    }
    public String simplifyPath(String path) {
        if(path.equals("/"))
            return "/";
        Stack<String> stack = new Stack<>();
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i <= path.length(); i++)
        {

            char c = i < path.length() ? path.charAt(i) : '/';
            if( c == '/' && temp.length() != 0)
            {
                if(temp.toString().equals("..") && stack.size() >= 1)
                {
                    stack.pop();
                }else if(!temp.toString().equals(".") && !temp.toString().equals(".."))
                {
                    stack.push(temp.toString());
                }
                temp.setLength(0);
            }else if(c != '/')
            {
                temp.append(c);
            }
        }
        temp.setLength(0);
        if(stack.isEmpty())
            temp.append("/");
        while(!stack.isEmpty())
        {
            temp.insert(0, stack.pop());
            temp.insert(0, "/");
        }
        return temp.toString();
    }
}
