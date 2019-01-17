package Incremental.Incremental3;

interface CycleFactory {
     void type();
}

class Unicycle implements CycleFactory {
    public void type() {
        System.out.println("Type: Unicycle");
    }
}

class Bicycle implements CycleFactory {
    public void type() {
        System.out.println("Type: Bicycle");
    }
}

class Tricycle implements CycleFactory {
    public void type() {
        System.out.println("Type: Tricycle");
    }
}

class CycleFactoryClass {
    public static CycleFactory createCycle(String type) {
        if("Unicycle".equalsIgnoreCase(type))
            return new Unicycle();
        else if ("Bicycle".equalsIgnoreCase(type))
            return new Bicycle();
        else if("Tricycle".equalsIgnoreCase(type))
            return  new Tricycle();
        else {
            System.out.println("Type doesn't match");
            return null;
        }
    }
}

class CycleFactoryMain {
    public static void main(String[] args) {
        CycleFactory unicycle = CycleFactoryClass.createCycle("UniCycle");
        unicycle.type();
        CycleFactory bicycle =  CycleFactoryClass.createCycle("BiCycle");
        bicycle.type();
        CycleFactory tricycle = CycleFactoryClass.createCycle("TriCycle");
        tricycle.type();
    }

}
