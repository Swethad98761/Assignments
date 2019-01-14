package Swetha.assignment.main;

import Swetha.assignment.data.Data;
import Swetha.assignment.singleton.SingleTon;

public class Main {
    public static void main(String args[])
    {
        //creating object for Data class
        Data data=new Data();
        data.printVariables();
        data.printLocalVariables();
        //creating object for SingleTon using static method returning instance
        SingleTon singleTon=SingleTon.setName("Swetha");
        singleTon.printName();

    }
}
