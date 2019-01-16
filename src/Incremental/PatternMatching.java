package Incremental;

import java.util.Scanner;
import java.util.regex.Pattern;

public class PatternMatching {
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String inputString=sc.nextLine();
        //regular expression for given pattern
        String regex="[A-Z].*\\.";
        //Pattern.compile is used to compile the regular expression
        //matcher is used to match the input with compiled regular expression
        //lookingAt returns true if the pattern matches otherwise false
        if(Pattern.compile(regex).matcher(inputString).matches())
        {
            System.out.println("Input String starts with an UpperCase alphabet and ends with .");
        }
        else
        {
            System.out.println("Input String does not starts with an UpperCase alphabet or ends with .");
        }
    }
}
