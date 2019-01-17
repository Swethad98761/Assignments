package Incremental.Incremental3;

class FirstClass{
    public class FirstInnerClass{
        public FirstInnerClass(String arg){
            System.out.println("This is First inner class");
        }
    }
}

class SecondClass{
    static class SecondInnerClass extends FirstClass.FirstInnerClass{
        public SecondInnerClass(FirstClass firstClass){
            firstClass.super("string arg");
            System.out.println("This is Second inner class");
        }
    }
}

class InnerClassMain {
    public static void main(String[] args) {
        FirstClass firstClass = new FirstClass();
        SecondClass.SecondInnerClass secondInnerClass = new SecondClass.SecondInnerClass(firstClass);
    }
}


