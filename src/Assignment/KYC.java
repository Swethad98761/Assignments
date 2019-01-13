package Assignment;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class KYC {
    public static void main(String args[]) throws IOException
    {
        //Used to read the input
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int testCases=Integer.parseInt(br.readLine());
        //DateTimeFormatter to print and accept the date of particular format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        while(testCases>0)
        {
            String input[]=br.readLine().split(" ");
            LocalDate signUpDate=LocalDate.parse(input[0],formatter);
            LocalDate currentDate=LocalDate.parse(input[1],formatter);
            //Trying to get the closest Anniversary by adding years
            LocalDate closestAnniversary=signUpDate.plusYears(currentDate.getYear()-signUpDate.getYear());
            LocalDate lowerBound=closestAnniversary.minusDays(30);
            LocalDate upperBound=closestAnniversary.plusDays(30);
            //compareTo is used to compare 2 dates
            if(currentDate.compareTo(signUpDate)<0)
            {
                System.out.println("No range");
            }
            else {
                if (currentDate.compareTo(lowerBound) * currentDate.compareTo(upperBound) < 0) {
                    upperBound = currentDate;
                }
                System.out.println(formatter.format(lowerBound) + " " + formatter.format(upperBound));
            }
            testCases--;
        }
    }
}
