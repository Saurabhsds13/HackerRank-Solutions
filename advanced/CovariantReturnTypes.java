package advanced;
/*Java allows for co-variant Return Types, which means you can vary your return type as long you are returning a subclass of your specified return type.

Method Overriding allows a subclass to override the behavior of an existing superclass method and specify a return type that is some subclass of the original return type. It is best practice to use the @Override annotation when overriding a superclass method.*/
	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;

	class Flower{String whatsYourName(){return "I have many names and types.";}}

	class Jasmine extends Flower{String whatsYourName(){return "Jasmine";}}
	    
	class Lily extends Flower{String whatsYourName(){return "Lily";}}

	class Region{Flower yourNationalFlower(){return new Flower();}}

	class WestBengal extends Region{Flower yourNationalFlower(){return new Jasmine();}}

	class AndhraPradesh extends Region{Flower yourNationalFlower(){return new Lily();}}


	public class CovariantReturnTypes {
	  public static void main(String[] args) throws IOException {
	      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	      System.out.println("Enter the Name of the State : ");
	      String s = reader.readLine().trim();
	      Region region = null;
	      switch (s) {
	        case "WestBengal":
	          region = new WestBengal();
	          break;
	        case "AndhraPradesh":
	          region = new AndhraPradesh();
	          break;
	      }
	      Flower flower = region.yourNationalFlower();
	      System.out.println(flower.whatsYourName());
	    }
}
