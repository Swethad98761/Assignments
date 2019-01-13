
// Java program for ping using sub-process

import sun.reflect.generics.tree.Tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class PingWebsite
{
    // method for finding the ping statics of website
    static void commands(ArrayList<String> commandList)
            throws Exception
    {
        // creating the sub process, execute system command
        ProcessBuilder build = new ProcessBuilder(commandList);
        Process process = build.start();

        // to read the output
        BufferedReader input = new BufferedReader(new InputStreamReader
                (process.getInputStream()));
        BufferedReader Error = new BufferedReader(new InputStreamReader
                (process.getErrorStream()));
        String s=null;
        Double times[]=new Double[9];
        System.out.println("Standard output: ");
        int packets=0;
        while((s = input.readLine()) != null)
        {   //splitting to get the time in ms
            String s1[] = s.split("time=");
            if(s1.length>=2) {
                //splitting to get the time
                String s2[]=s1[1].split(" ");
                if(packets<9) {
                    //converting string to double
                    times[packets]=Double.parseDouble(s2[0]);
                    packets++;
                }
                else
                {
                    break;
                }
            }
        }
        //Sorting times to get the median
        Arrays.sort(times);
        System.out.println("The median of the time taken to ping is:"+times[4]);
    }

    // Driver method
    public static void main(String args[]) throws Exception
    {
        // creating list for commands
        ArrayList<String> commandList = new ArrayList<String>();

        commandList.add("ping");
        // can be replaced by IP
        commandList.add("www.google.com");
        PingWebsite.commands(commandList);
    }
}
