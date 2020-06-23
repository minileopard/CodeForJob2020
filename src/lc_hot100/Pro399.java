package lc_hot100;

import java.util.*;

public class Pro399 {
    public static void main(String[] args) {
        //[["x1","x2"],["x2","x3"],["x3","x4"],["x4","x5"]]
        //[3.0,4.0,5.0,6.0]
        //[["x1","x5"],["x5","x2"],["x2","x4"],["x2","x2"],["x2","x9"],["x9","x9"]]
        String[][] slist = {{"x1","x2"},{"x2","x3"},{"x3","x4"},{"x4","x5"}};
        List<List<String>> equations = new ArrayList<>();
        for(String[] ss : slist)
        {
            List<String> temp = new ArrayList<>();
            for(String s: ss)
            {
                temp.add(s);
            }
            equations.add(temp);
        }
        double[] values = {3.0,4.0,5.0,6.0};
        //
        String[][] sslist = {{"x1","x3"},{"x5","x2"},{"x2","x4"},{"x2","x2"},{"x2","x9"},{"x9","x9"}};
        List<List<String>> queries = new ArrayList<>();
        for(String[] ss : sslist)
        {
            List<String> temp = new ArrayList<>();
            for(String s: ss)
            {
                temp.add(s);
            }
            queries.add(temp);
        }
        double[] res = new Pro399().calcEquation_bcj_ys(equations, values, queries);
        for(double f:res)
            System.out.print(f + " ");
        System.out.println();
    }
    //带路径压缩的并查集方法
    public String findroot_ys(String p)
    {
        if(path.get(p)!=p)//自己到自己说明已经到结尾了到根了，只有根的父节点是根
        {
            String fa = path.get(p);
            path.put(p, findroot_ys(fa));//递归地将上层所有子变成父的根节点的子。
            len.put(p, len.get(p) * len.get(fa));//更新子到根的路径
        }
        return path.get(p);
    }
    public void union_ys(String s, String e, double num)
    {
        //初始化自己到自己权值为1.0，自己的根是自己
        init(s);init(e);
        //找到根然后从根开始扩展，保持并查集始终是一个树形根只有一个所有分支都和根直连
        String ss = findroot_ys(s);
        String ee = findroot_ys(e);
        if(ss == ee)
        {
            return;//说明是同一个根节点的内部，不需要增加重复的边了。
        }
        path.put(ss,ee);
        len.put(ss, num * (len.get(e)/len.get(s)));
    }
    public double[] calcEquation_bcj_ys(List<List<String>> equations, double[] values, List<List<String>> queries)
    {
        for (int i = 0; i < equations.size(); i++)
        {
            List<String> list = equations.get(i);
            union_ys(list.get(0), list.get(1), values[i]);
        }
        int len = queries.size();
        double[] res = new double[len];
        for (int i = 0; i < len; i++) {
            List<String> ts = queries.get(i);
            String start = ts.get(0);
            String end = ts.get(1);
            //根不存在或者根不相同都为-1
            if(!path.containsKey(start) || !path.containsKey(end) || !findroot_ys(start).equals(findroot_ys(end)))
            {
                res[i] = -1.0f;
            }else
            {
                res[i] = this.len.get(start)/this.len.get(end);
            }
        }
        return res;
    }

    //不带路径压缩的并查集方法
    public HashMap<String, String> path = new HashMap<>();//子->父节点映射关系
    public HashMap<String, Double> len = new HashMap<>();//当前节点到父节点的路径权值，除数是父
    public String findroot(String p)
    {
        while(path.get(p)!=p)//自己到自己说明已经到结尾了到根了，只有根的父节点是根
        {
            p = path.get(p);
        }
        return p;
    }
    //初始化自己到父节点自己的权值
    public void init(String s)
    {
        if(!path.containsKey(s))
        {
            path.put(s, s);
            len.put(s, 1.0);
        }
    }
    //两个节点之间出现一条边
    public void union(String s, String e, double num)
    {
        //初始化自己到自己权值为1.0，自己的根是自己
        init(s);init(e);
        //找到根然后从根开始扩展，保持并查集始终是一个树形根只有一个所有分支都和根直连
        String ss = findroot(s);
        String ee = findroot(e);
        if(ss == ee)
        {
            return;//说明是同一个根节点的内部，不需要增加重复的边了。
        }
        path.put(ss,ee);
        len.put(ss, num * (cal(e)/cal(s)));
    }
    //查找从当前节点到根的累计路径权值
    public double cal(String s)
    {
        double res = len.get(s);
        while(path.get(s)!=s)//根节点不是自己说明还没找到根，根的根节点一定是自己
        {
            s = path.get(s);
            res *= len.get(s);
        }
        return res;
    }
    //并查集方法
    public double[] calcEquation_bcj(List<List<String>> equations, double[] values, List<List<String>> queries)
    {
        for (int i = 0; i < equations.size(); i++)
        {
            List<String> list = equations.get(i);
            union(list.get(0), list.get(1), values[i]);
        }
        int len = queries.size();
        double[] res = new double[len];
        for (int i = 0; i < len; i++) {
            List<String> ts = queries.get(i);
            String start = findroot(ts.get(0));
            String end = findroot(ts.get(1));
            //根不存在或者根不相同都为-1
            if(!path.containsKey(start) || !path.containsKey(end)||!start.equals(end))
            {
                res[i] = -1.0f;
            }else
            {
                res[i] = cal(ts.get(0)) / cal(ts.get(1));
            }
        }
        return res;
    }

    //DFS方法
    public double num = 0.0;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, HashMap<String, Double>> map = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> ts = equations.get(i);
            double ti = values[i];
            //a->b
            HashMap<String, Double> tm = map.getOrDefault(ts.get(0), new HashMap<>());
            tm.put(ts.get(1), ti);
            map.put(ts.get(0), tm);
            //b->a
            HashMap<String, Double> tm1 = map.getOrDefault(ts.get(1), new HashMap<>());
            tm1.put(ts.get(0), 1/ti);
            map.put(ts.get(1), tm1);
        }
        int len = queries.size();
        double[] res = new double[len];
        for (int i = 0; i < len; i++) {
            List<String> ts = queries.get(i);
            String start = ts.get(0);
            String end = ts.get(1);
            if(!map.containsKey(start) || !map.containsKey(end))
            {
                res[i] = -1.0f;
                continue;
            }else if(start.equals(end))
            {
                res[i] = 1.0f;
                continue;
            }
            Set<String> vis = new HashSet<String>();
            num = -1;
            getDouble(vis, map, start, end, 1.0);
            res[i] = num;
        }
        return res;
    }
    public void getDouble(Set<String> vis, HashMap<String, HashMap<String, Double>> map, String s, String e, double mul)
    {
        HashMap<String, Double> list = map.get(s);
        if(list == null || list.isEmpty()||vis.contains(s))
            return;
        if(list.containsKey(e))
        {
            num = mul * list.get(e);
            return;
        }
        vis.add(s);
        for(String ts:list.keySet())
        {
            getDouble(vis, map, ts, e, list.get(ts) * mul);
        }
    }
}
