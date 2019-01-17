package Incremental.Incremental3;

//base class and it is an abstract class which may contain both abstract and non abstract methods
abstract class Rodent {
    //abstract method with just declaration
    public abstract void color();
    Rodent() {
        System.out.println("This is Rodent class");
    }
}

//Subclass extending Rodent class
class Mouse extends Rodent {
    Mouse() {
        System.out.println("This is Mouse class");
    }
    //defining the abstract class of Rodent
    public void color( ) {
        System.out.println("The Color of Mouse is grey" );
    }
}

//Subclass extending Rodent class
class Gerbil extends Rodent {
    Gerbil() {
        System.out.println("This is Gerbil class");
    }
    //defining the abstract class of Rodent
    public void color( ) {
        System.out.println("The Color of Gerbil is white");
    }
}

//Subclass extending Rodent class
class Hamster extends Rodent {
    Hamster() {
        System.out.println("This is Hamster class");
    }
    //defining the abstract class of Rodent
    public void color( ) {
        System.out.println("The Color of Hamster is black");
    }
}

public class RodentMain {
    public static void main(String a[]) {
        Rodent array[] = new Rodent[3];
        array[0] = new Mouse();
        array[0].color();
        array[1] = new Gerbil();
        array[1].color();
        array[2] = new Hamster();
        array[2].color();
    }
}