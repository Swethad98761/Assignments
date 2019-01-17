package Incremental.Incremental2;

public class InitialiseConstructor {
    public InitialiseConstructor(String args)
    {
        System.out.println(args);
    }
    public static void main(String args[])
    {
        //Just Created Array of references but not assigned objects
        InitialiseConstructor array[]=new InitialiseConstructor[5];
    }
}
