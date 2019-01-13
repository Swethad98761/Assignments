package Assignment;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.regex.Pattern;


public class FindFile {

    public static void main(String[] args) {
        /*Scanner object for reading the input*/
        Scanner scan=new Scanner(System.in);
        String Continue="yes";
        /*loop used to take continuous input*/
        while(true) {
        System.out.println("Enter any Regular Expression to search for a file:");
        String inputRegex=scan.next();
        //home directory path
        File filePath = new File("/home/swetha");
        String[] list;
        list = filePath.list(new DirFilter(inputRegex));
        //Sorting the list using AlphabeticComparator
        Arrays.sort(list, new AlphabeticComparator());
        for (int i = 0; i < list.length; i++)

            System.out.println(list[i]);

        System.out.println("If you want to continue press yes otherwise press no:");
        Continue=scan.next();

        if(Continue.equals("no"))
            break;
        }
    }
}

//Used for regex matching
class DirFilter implements FilenameFilter {
    private Pattern pattern;

    public DirFilter(String reg) {
        pattern = Pattern.compile(reg);
    }

    @Override
    public boolean accept(File dir, String name) {
        // Strip path information, search for regex:
        return pattern.matcher(new File(name).getName()).find();
    }
}

//Sorting list of files
class AlphabeticComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        String str1 = (String) o1;
        String str2 = (String) o2;
        return str1.toLowerCase().compareTo(str2.toLowerCase());
    }
}
