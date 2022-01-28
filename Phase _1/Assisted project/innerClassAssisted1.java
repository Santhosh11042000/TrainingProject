package inner;

public class innerClassAssisted1 {

	 private String msg="Hai All"; 
	 
	 class Inner{  
	  void hello(){
		  System.out.println(msg+", How r u");}  
	 }  


	public static void main(String[] args) {

		innerClassAssisted1 obj=new innerClassAssisted1();
		innerClassAssisted1.Inner in=obj.new Inner();  
		in.hello();  
	}
}
