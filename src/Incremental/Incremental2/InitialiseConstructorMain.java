package Incremental.Incremental2;

class InitialiseConstructorMain{
    InitialiseConstructorMain(String s){
        System.out.println(s);
    }
    public static void main(String[] args) {
        InitialiseConstructorMain[] array = new InitialiseConstructorMain[5];
        //Created Objects and assigned to array of references
        for(int index=0;index<5;index++)
        {
            array[index]=new InitialiseConstructorMain("Hello,This is Constructor");
        }

    }
}
