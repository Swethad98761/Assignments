package Incremental;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

public class ReadFile {
    public static void main(String args[]) throws Exception {
        //Passed input as a Commanline argument
        String input=args[0];
        //Reading from the file using FileReader
        FileReader fileReader=new FileReader(input);
        File file = new File("/home/swetha/Desktop/output.txt");
        FileWriter fileWriter = new FileWriter(file, false);
        //HashMap for maintaining frequency of each character
        HashMap<Character,Integer> map=new HashMap<>();
        int position;
        //loop for reading from the file
        while((position=fileReader.read())!=-1)
        {
         if(map.get((char)position)==null)
         {
             map.put((char)position,1);
         }
         else
         {
             map.put((char)position,map.get((char)position)+1);
         }
        }

        String outPut="";
        //Iterating map and appending the output to the output string.
        for(Map.Entry<Character,Integer> entry:map.entrySet())
        {
           outPut=outPut+"Charactor:"+entry.getKey()+" Count:"+entry.getValue()+"\n";
        }
        //Writing the output to output file using FileWriter
        fileWriter.write(outPut);
        fileReader.close();
        fileWriter.close();
    }
}
