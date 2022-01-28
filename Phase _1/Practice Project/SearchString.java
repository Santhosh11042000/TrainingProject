package Project11;
import java.util.Scanner;

public class SearchString {

	public static void main(String[] args) {
		String[]name= {"Sanjay@gmail.com","Appu@gmail.com","Ganesh@gmail.com","Rohith@gmail.com"};
		Scanner in=new Scanner(System.in);
		System.out.println("Enter the Name:");
		String toFind=in.nextLine();
		boolean found=false;
		for(String n: name) {
			
				if(n.equals(toFind)) {
					found=true;
					break;
				}
			}
			if(found) {
				System.out.println(toFind+" is found");
			
			}
			else {
				System.out.println(toFind+" is not found");
				
			}
		
		}

	}


