package others;
class Singleton {
    /**
     * 类级的内部类，也就是静态的成员式内部类，该内部类的实例与外部类的实例
     * 没有绑定关系，而且只有被调用到才会装载，从而实现了延迟加载
     */
    private static class SingletonHolder{
        /**
         * 静态初始化器，由JVM来保证线程安全
         */
        static {
            System.out.println("create SingletonHolder");
        }
        private static Singleton instance = new Singleton();
    }
    /**
     * 私有化构造方法
     */
    private Singleton(){
        System.out.println("create Singleton");
    }
    public static  Singleton getInstance(){
        System.out.println("create");
        return SingletonHolder.instance;
    }
}

public class TestSingleton {
    static Singleton s;
    public static void main(String[] args) {
        System.out.println("hello");
        s = Singleton.getInstance();
    }
}

