package Assignment;
import java.util.*;
public class PanGram {
    //Time Complexity is O(n) where n is the input string length
    //Space Complexity is O(1)
    // function used to check whether the given string is pangram or not
    public static boolean isPangram(String inputString)
    {
        // Converting the String into lowerCase we used toLowercase method
        String lowerCaseString=inputString.toLowerCase();
        //checking each letter using filter
        if(lowerCaseString.chars().filter(inputChar -> inputChar >= 'a' && inputChar <= 'z').distinct().count() == 26)
        {
            return true;
        }
        else
        {
            return false;
        }

    }
    public static void main(String args[]) {

        /*Scanner for reading the input String*/
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter input String:");
        String inputString = scanner.next();
        if(isPangram(inputString))
        {
            System.out.println("Yes,the given input string contains all the alphabets");
        }
        else
        {
            System.out.println("No,the given input string does not contain all the alphabets");
        }

    }
}
