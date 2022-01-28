package Assessment 1;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
public class Ass1 {
	static String DIRECTORY;
    File folder_name;

    public Ass1() {
        DIRECTORY = System.getProperty("user.dir");
        folder_name = new File(DIRECTORY+"/Files");
        if (!folder_name.exists())
            folder_name.mkdirs();
        System.out.println("PATH : "+ folder_name.getAbsolutePath());
    }

    private static final String OPEN =
            "\n******* ASSESSMENT-1*******"+
                    "\n******* SANTHOSH*******\n";

    private static final String MENU =
            "\nMENU - Select any one : \n"+
                    "1 - List files in directory\n"+
                    "2 - Add, Delete, Search\n"+
                    "3 - Exit";

    private static final String SECOND =
            "   \nSelect any one : \n"+
                    "   a - Add a file\n"+
                    "   b - Delete a file\n"+
                    "   c - Search a file\n"+
                    "   d - GoBack";

    void showPrimaryMenu() {
        System.out.println(MENU);
        try{
            Scanner scanner = new Scanner(System.in);
            int option = scanner.nextInt();
            switch (option){
                case 1 : {
                    showFiles();
                    showPrimaryMenu();
                }
                case 2 : {
                    showSecondaryMenu();
                }
                case 3 : {
                    System.out.println("WELCOME");
                    System.exit(0);
                }
                default: showPrimaryMenu();
            }
        }
        catch (Exception e){
            System.out.println("Please enter 1, 2 or 3");
            showPrimaryMenu();
        }
    }

    void showSecondaryMenu() {
        System.out.println(SECOND);
        try{
            Scanner scanner = new Scanner(System.in);
            char[] input = scanner.nextLine().toLowerCase().trim().toCharArray();
            char option = input[0];

            switch (option){
                case 'a' : {
                    System.out.print("↳ Add a file- Enter a File Name : ");
                    String filename = scanner.next().trim().toLowerCase();
                    addFile(filename);
                    break;
                }
                case 'b' : {
                    System.out.print("↳ Delete a file-Enter a File Name : ");
                    String filename = scanner.next().trim();
                    deleteFile(filename);
                    break;
                }
                case 'c' : {
                    System.out.print("↳ Search a file- Enter a File Name : ");
                    String filename = scanner.next().trim();
                    searchFile(filename);
                    break;
                }
                case 'd' : {
                    showPrimaryMenu();
                    break;
                }
                default : System.out.println("Please enter a, b, c or d");
            }
            showSecondaryMenu();
        }
        catch (Exception e){
            System.out.println("Please enter a, b, c or d");
            showSecondaryMenu();
        }
    }

    void showFiles() {
        if (folder_name.list().length==0)
            System.out.println("folder is empty");
        else {
            String[] list = folder_name.list();
            System.out.println("The files in "+ folder_name +" are :");
            Arrays.sort(list);
            for (String str:list) {
                System.out.println(str);
            }
        }
    }

    void addFile(String FileName) throws IOException {
        File filepath = new File(folder_name +"/"+FileName);
        String[] list = folder_name.list();
        for (String file: list) {
            if (FileName.equalsIgnoreCase(file)) {
                System.out.println("File " + FileName + " already exists at " + folder_name);
                return;
            }
        }
        filepath.createNewFile();
        System.out.println("File "+FileName+" added to "+ folder_name);
    }

    void deleteFile(String FileName) {
        File filepath = new File(folder_name +"/"+FileName);
        String[] list = folder_name.list();
        for (String file: list) {
            if (FileName.equals(file) && filepath.delete()) {
                System.out.println("File " + FileName + " deleted from " + folder_name);
                return;
            }
        }
        System.out.println("Delete Operation failed. FILE NOT FOUND");
    }

    void searchFile(String FileName) {
        String[] list = folder_name.list();
        for (String file: list) {
            if (FileName.equals(file)) {
                System.out.println("FOUND : File " + FileName + " exists at " + folder_name);
                return;
            }
        }
        System.out.println("File NOT found (FNF)");
    }

	public static void main(String[] args) {
	
		System.out.println(OPEN);
        Ass1 menu = new Ass1();
        menu.showPrimaryMenu();

	}

}
