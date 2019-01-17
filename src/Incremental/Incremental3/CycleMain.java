package Incremental.Incremental3;

class Cycle{
}

class UniCycle extends Cycle {
    public void balance(){
        System.out.println("This is Unicycle balance method");
    }
}

class BiCycle extends Cycle {
    public void balance(){
        System.out.println("This is Bicycle balance method");
    }
}

class TriCycle extends Cycle {

}

class CycleMain {
    public static void main(String[] args) throws ClassCastException{
        UniCycle unicycle = new UniCycle();
        BiCycle  bicycle  = new BiCycle();
        TriCycle tricycle = new TriCycle();
        Cycle[] cycleArr  = new Cycle[3];
        //Cannot upcast and call balance method as there is no balance method in Cycle class
        cycleArr[0]=(Cycle)unicycle;
        cycleArr[1]=(Cycle)bicycle;
        cycleArr[2]=(Cycle)tricycle;
        //cannot upcast and make the below call
        //cycleArr[0].balance();
        //downcasting
        ((UniCycle)cycleArr[0]).balance();
        ((BiCycle)cycleArr[1]).balance();
        //Cannot downCast to TriCycle and call balance method as there is no balance method in TriCycle class
        //((TriCycle)cycleArr[2]).balance();
    }
}
