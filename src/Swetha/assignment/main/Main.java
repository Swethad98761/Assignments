package Swetha.assignment.main;

import Swetha.assignment.data.Data;
import Swetha.assignment.singleton.SingleTon;

public class Main {
    public static void main(String args[])
    {
        Data data=new Data();
        data.printVariables();
        data.printLocalVariables();
        SingleTon singleTon=SingleTon.setName("Swetha");
        singleTon.printName();

    }
}
