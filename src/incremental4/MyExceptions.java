package incremental4;

public class MyExceptions extends Exception{
    MyExceptions(String str)
    {
        super(str);
    }
    public static void verifyDetails(String name,String phoneNo,long balance,String accountNo)
    {
        //Throws the exception
       try
       {
           if(phoneNo.length()!=10)
           {
               //Raises exception if the phone number is invalid
               MyExceptions exception=new MyExceptions("Phone number should contain 10 digits");
               throw exception;
           }
           else
           {
               System.out.println("Phone number is verified");
           }
           if(balance<1000)
           {
               //Raises exception if there's no sufficient account balance
               MyExceptions exception=new MyExceptions("Balance should be greater than 1000");
               throw exception;
           }
           if(accountNo.matches("[0-9]+") && accountNo.length() > 2)
           {
               System.out.println("Account Number is verified");
           }
           else
           {
               //Raises exceptiton if the account number is invalid
               MyExceptions exception=new MyExceptions("Account Number should contain only digits");
               //Manually throws an Exception
               throw exception;
           }
       }
       //Catch block executes when the try block raises any exception
       catch(MyExceptions exception)
       {
          exception.printStackTrace();
       }
       //Any code that absolutely must be executed after a try block completes is put in a finally block
       finally {
           System.out.println("Details are:");
           System.out.println("Name:"+name+" Account Number:"+accountNo+" Contact:"+phoneNo+" Account Balance:"+balance);
       }
    }
    public static void main(String args[])
    {
     String name="Swetha";
     String phoneNo="8282829080";
     long balance=20000;
     String accountNo="101hswkjsskxm";
     //Method throws 3 Exceptions
     verifyDetails(name,phoneNo,balance,accountNo);
    }
}
