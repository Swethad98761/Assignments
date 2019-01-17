package Incremental.Incremental2;

public class TwoOverloadedConstructors {
    public TwoOverloadedConstructors(boolean flag)
    {
        this(125);
        System.out.println("This is first constructor");
    }
    public TwoOverloadedConstructors(int a)
    {
        System.out.println("Second Constructor is called from the first");
    }
    public static void main(String args[])
    {
        TwoOverloadedConstructors twoOverloadedConstructors=new TwoOverloadedConstructors(true);
    }
}
