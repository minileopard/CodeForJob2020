package others;
class A {
    static {
        System.out.print("A");
    }
    public A() {
        System.out.print("a");
    }
    void say() {
        System.out.print("1");
    }
}
class B extends A {
    static {
        System.out.print("B");
    }
    public B() {
        System.out.print("b");
    }
    void say() {
        System.out.print("2");
    }
}
interface Moveable{
    void move();
}
public class test implements Moveable{
    public static void main(String[] args) {
//        A ab = new B();
//        ab.say();
//        ab = new B();
//        ab.say();
        Integer i = 127;
        Integer j = 127;
        System.out.println(i == j);
        i = +1;
        j = +1;
        System.out.println(i == j);
    }

    @Override
    public void move() {
        String s = "hi";
    }
}
