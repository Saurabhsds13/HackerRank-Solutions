package challenges;
import java.io.IOException;

/*You are given a class Solution and an inner class Inner.Private. The main method of class Solution takes an integer  as input. The powerof2 in class Inner.Private checks whether a number is a power of . You have to call the method powerof2 of the class Inner.Private from the main method of the class Solution.*/

public class Can_You_Access {

	public static void main(String[] args) throws NumberFormatException, IOException {
//		DoNotTerminate.forbidExit();
		
		try{
			// use buffer reader for input
			int num = 8;
			Object o ;// Must be used to hold the reference of the instance of the class Solution.Inner.Private
			
			 o = new Inner().new Private();
	            String response= ((Inner.Private)o).powerof2(num);
	           System.out.println(num+" is "+response);
			
		System.out.println("An instance of class: " + o.getClass().getCanonicalName() + " has been created");
		
		}//end of try
		
		catch (DoNotTerminate.ExitTrappedException e) {
			System.out.println("Unsuccessful Termination!!");
		}

	}
	
	
	static class Inner{
		private class Private{
			private String powerof2(int num){
				return ((num&num-1)==0)?"power of 2":"not a power of 2";
			}
		}
	}//end of Inner

}

class DoNotTerminate { //This class prevents exit(0)
	 
    public static class ExitTrappedException extends SecurityException {

		private static final long serialVersionUID = 1L;
    }
 
//    @SuppressWarnings("removal")
//	public static void forbidExit() {
//        @SuppressWarnings({ "deprecation" })
//		final SecurityManager securityManager = new SecurityManager() {
//            @Override
//            public void checkPermission(Permission permission) {
//                if (permission.getName().contains("exitVM")) {
//                    throw new ExitTrappedException();
//                }
//            }
//        };
//        System.setSecurityManager(securityManager);
    }
//}