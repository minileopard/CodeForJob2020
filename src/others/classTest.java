package others;

public class classTest {
    public classTest(){
        System.out.println("A");
    }
    {
        System.out.println("B");
    }
    static {
        System.out.println("C");
    }
}
class inner extends classTest{
    public inner()
    {
        System.out.println("D");
    }
    {
        System.out.println("E");
    }
    static {
        System.out.println("F");
    }
    public static void main(String[] args) {
        new classTest();
        new inner();
    }
}
