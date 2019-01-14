package Swetha.assignment.data;

public class Data {
    int classVariable1;
    char classVariable2;
    public void printVariables()
    {
       System.out.println("The class member variables default values are:"+classVariable1+" "+classVariable2);
    }
    public void printLocalVariables()
    {
        int localVariable1;
        char localVariable2;
       //System.out.println(localVariable1+" "+localVariable2);
        //local Variables need to need to be Initialized
        System.out.println("local variables need to be initialised");
    }
}
