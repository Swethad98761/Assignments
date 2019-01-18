package Assignment;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.time.temporal.ChronoUnit;


public class KYC {
    //To check whether the currentDate is in between startingDate and endingDate
    public static boolean isInBetweenDates(LocalDate startingDate,LocalDate endingDate,LocalDate currentDate) {
        //compareTo is used to compare 2 dates
        if(currentDate.compareTo(startingDate) * currentDate.compareTo(endingDate) <0)
        {
            return true;
        }
        else
        {
            return false;
        }

    }
    public static LocalDate getClosestDate(LocalDate anniversaryDateOfCurrentYear,LocalDate anniversaryDateOfPreviousYear,LocalDate currentDate) {
        if(ChronoUnit.DAYS.between(currentDate,anniversaryDateOfCurrentYear) > 30)
        {
            return anniversaryDateOfPreviousYear;
        }
        else if(Math.abs(ChronoUnit.DAYS.between(currentDate,anniversaryDateOfCurrentYear)) >= Math.abs(ChronoUnit.DAYS.between(anniversaryDateOfPreviousYear,currentDate)))
        {
            return anniversaryDateOfPreviousYear;
        }
        else
        {
            return anniversaryDateOfCurrentYear;
        }

    }
    public static void main(String[] args) {
        //Used to read the input
        Scanner scanner = new Scanner(System.in);
        int noOfTestCases = scanner.nextInt();
        for (int testCase = 0; testCase < noOfTestCases; testCase++) {
            String signUpDateInString = scanner.next();
            String currentDateInString = scanner.next();
            //DateTimeFormatter to print and accept the date of particular format
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate signUpDate = LocalDate.parse(signUpDateInString, formatter);
            LocalDate currentDate = LocalDate.parse(currentDateInString, formatter);
            if (signUpDate.getYear() >= currentDate.getYear() || signUpDate.plusYears(1).minusDays(30).compareTo(currentDate)>0) {
                System.out.println("No Range");
            }
            else {
                //Trying to get the closest Anniversary by adding years
                LocalDate anniversaryDateOfCurrentYear = signUpDate.plusYears(currentDate.getYear() - signUpDate.getYear());
                LocalDate anniversaryDateOfPreviousYear= anniversaryDateOfCurrentYear.minusYears(1);
                LocalDate closestAnniversaryDate=getClosestDate(anniversaryDateOfCurrentYear,anniversaryDateOfPreviousYear,currentDate);
                LocalDate startingDate = closestAnniversaryDate.minusDays(30);
                LocalDate endingDate = closestAnniversaryDate.plusDays(30);
                if(isInBetweenDates(startingDate,endingDate,currentDate)) {
                    System.out.println(formatter.format(startingDate)+" "+formatter.format(currentDate));
                }
                else {
                    System.out.println(formatter.format(startingDate)+" "+formatter.format(endingDate));
                }
            }
        }
    }
}