package FileHandling;
import java.io.BufferedReader;
import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
public class FileHandling
{
    public static void main(String args[]) throws FileNotFoundException, IOException {
        System.out.println("Press any one of the following");
        System.out.println(" w - write ");
        System.out.println(" r - read ");
        System.out.println(" a - append ");
        Scanner in =new Scanner(System.in);
        String s=in.nextLine();
        if(s.equalsIgnoreCase("r"))
        {
            new FReading();
        }
        else if(s.equalsIgnoreCase("w")||s.equalsIgnoreCase("a"))
        {
            writingToFile(s);
            
            
        }
        else
        {
            System.out.println("Sorry didn't exists try again ");
        }
        
        
        in.close();
        
    }
    
    public static void writingToFile(String s)
    {
        Scanner in=null;
        try
        {
            String source = "";
            File f=new File("file.txt");
            
            BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
            //For writing new Content Everytime you run
            FileWriter f0 =null;
            if(s.equalsIgnoreCase("w"))
            {
                f0 = new FileWriter(f,false);
                System.out.println("Reminder- It will overwrite the content of the file ");
                System.out.println("To exit:Type 'NO' ");
                System.out.println("Want to proceed :Type 'YES' ");
                in=new Scanner(System.in);
                String s1=in.nextLine();
                if(s1.equals("no"))
                System.exit(0);
                System.out.println(" When you finish writing file-Type 'STOP' ");
                f.delete();
                f.createNewFile();
                while(!(source=bf.readLine()).equalsIgnoreCase("STOP")){
                    f0.write(source + System.getProperty("line.separator"));
                    
                }
                
                in.close();
            }
            //For appending the content
            else
            {  f0 = new FileWriter(f,true);
                System.out.println("When you finish writing file -Type 'STOP' ");
                while(!(source=bf.readLine()).equalsIgnoreCase("STOP")){
                    f0.append(source+ System.getProperty("line.separator"));
                }
            }
            f0.close();
            
        }
        catch(Exception e){
            System.out.println("Error : " );
            e.printStackTrace();
        }
        
        
    }
    
    
    
}

class FReading {
    public static String str="";
    
    public FReading() {
        
        try{
            File f5=new File("file.txt");
            if(! f5.exists())
            f5.createNewFile();
            FileReader fl=new FileReader(f5);
            BufferedReader bf=new BufferedReader(fl);
            //For reading till end
            while((str=bf.readLine())!=null){
                System.out.println(str);
            }
            fl.close();
            }catch(Exception e){
            System.out.println("Error : " );
            e.printStackTrace();
        }
    }
}