package lc_company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


class AllOne {
    class LinkedNode{
        LinkedNode pre, next;
        Set<String> keyset;
        LinkedNode(){
            keyset = new HashSet<>();
            pre = null;
            next = null;
        };
    }
    HashMap<String, Integer> map;
    HashMap<Integer, LinkedNode> listmap;
    LinkedNode head, tail;
    /** Initialize your data structure here. */
    public AllOne() {
        map = new HashMap<>();
        listmap = new HashMap<>();
        head = new LinkedNode();
        tail = new LinkedNode();
        head.next = tail;
        tail.pre = head;
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        //处理map
        int count = map.getOrDefault(key, 0);
        map.put(key, count + 1);
        //处理listmap和链表

        if(count == 0)
        {
            if(!listmap.containsKey(count+1))
            {
                //count为0说明新插入了
                LinkedNode lk = new LinkedNode();
                lk.keyset.add(key);
                lk.next = head.next;
                head.next.pre = lk;
                head.next = lk;
                lk.pre = head;
                listmap.put(count+1, lk);
            }else
            {
                LinkedNode lk = listmap.get(count+1);
                lk.keyset.add(key);
            }
        }else
        {
            //删掉当前，添加到后面
            LinkedNode lk = listmap.get(count);
            lk.keyset.remove(key);
            if(lk.keyset.isEmpty())
            {
                listmap.remove(count);
            }
            //
            if(!listmap.containsKey(count+1))
            {
                LinkedNode lknext = new LinkedNode();
                lknext.keyset.add(key);
                if(lk.keyset.isEmpty())
                {
                    lknext.pre = lk.pre;
                    lknext.next = lk.next;
                    lk.pre.next = lknext;
                    lk.next.pre = lknext;
                }else
                {
                    lknext.pre = lk;
                    lknext.next = lk.next;
                    lk.next.pre = lknext;
                    lk.next = lknext;
                }
                listmap.put(count+1, lknext);
            }else
            {
                LinkedNode lknext = listmap.get(count+1);
                lknext.keyset.add(key);
                if(lk.keyset.isEmpty())
                {
                    lknext.pre = lk.pre;
                    lk.pre.next = lknext;
                }
            }
        }
    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        int count = map.getOrDefault(key, 0);
        if(count == 0)
        {
            return;
        }
        else if(count == 1) {
            map.remove(key);
        }
        else {
            map.put(key, count - 1);
        }
        //处理当前节点
        LinkedNode tk = listmap.get(count);
        tk.keyset.remove(key);
        //需要删掉这个节点吗
        if(tk.keyset.isEmpty())
        {
            listmap.remove(count);
        }
        if(count == 1)
        {
            //要从链表删除
            if(tk.keyset.isEmpty()){
                tk.next.pre = tk.pre;
                tk.pre.next = tk.next;
            }
            return;
        }

        //处理前一个节点
        if(listmap.containsKey(count-1))
        {
            LinkedNode tkpre = listmap.get(count-1);
            tkpre.keyset.add(key);
            if(tk.keyset.isEmpty())
            {
                tkpre.next = tk.next;
                tk.next.pre = tkpre;
            }
        }else
        {
            LinkedNode tkpre = new LinkedNode();
            tkpre.keyset.add(key);
            if(tk.keyset.isEmpty())
            {
                tkpre.next = tk.next;
                tkpre.pre = tk.pre;
                tk.pre.next = tkpre;
                tk.next.pre = tkpre;
            }else
            {
                tkpre.next = tk;
                tkpre.pre = tk.pre;
                tk.pre.next = tkpre;
                tk.pre = tkpre;
            }
            listmap.put(count - 1, tkpre);
        }
    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        if(tail.pre.pre == null)
            return "";
        else
            return tail.pre.keyset.iterator().next();
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        if(head.next.next == null)
            return "";
        else
            return head.next.keyset.iterator().next();
    }
}
public class Pro432_zj {
    public static void main(String[] args) {
        AllOne obj = new AllOne();
        obj.inc("a");
        obj.inc("b");
        obj.inc("c");
        obj.inc("c");
        obj.inc("c");
        obj.dec("b");
        obj.dec("b");
        System.out.println(obj.getMinKey());
        obj.dec("a");
        System.out.println(obj.getMaxKey());
        System.out.println(obj.getMinKey());
    }
}
/*
//已经有该数目
        else
        {
            //这时一定时

        }


        //再将key加到count+1里面去
        LinkedNode tknext;
        if(listmap.containsKey(count + 1))
        {
            tknext = listmap.get(count + 1);
            tknext.keyset.add(key);
        }else
        {
            tknext = new LinkedNode();
            if(tk.keyset.isEmpty())
            {
                listmap.remove(count);
                //绕过tk节点
                tknext.pre = tk.pre;
                tk.pre.next = tknext;
                tknext.next = tk.next;
                tk.next.pre = tknext;
            }else
            {
                tknext.pre = tk;
                tknext.next = tk.next;
                tk.next = tknext;
                tk.next.pre = tknext;
            }
            tknext.keyset.add(key);
        }
        listmap.put(count+1, tknext);
 */