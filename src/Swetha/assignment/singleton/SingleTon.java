package Swetha.assignment.singleton;

public class SingleTon {
    String name="Swetha";
    public static SingleTon setName(String name)
    {
        //non-static variables cannot be accesed by static methods
        // this.name=name;
        return new SingleTon();
    }
    public void printName()
    {
        System.out.println("The String is:"+name);
    }

}
