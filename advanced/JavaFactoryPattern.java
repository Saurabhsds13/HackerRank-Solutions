package advanced;

import java.util.Scanner;

interface Food {
  public String getType();
}

class Pizza implements Food {

  public String getType() {
    return "Someone ordered a Fast Food!";
  }
}

class Cake implements Food {

  public String getType() {
    return "Someone ordered a Dessert!";
  }
}

class FoodFactory {

  public Food getFood(String order) {
    if (order.equals("Cake")) {
      return new Cake();
    }
    if (order.equals("Pizza")) {
      return new Pizza();
    } else return null;
  }
}

public class JavaFactoryPattern {

  public static void main(String[] args) {
    try {
      Scanner sc = new Scanner(System.in);
      //creating the factory
      FoodFactory foodFactory = new FoodFactory();

      //factory instantiates an object
      Food food = foodFactory.getFood(sc.nextLine());
      sc.close();
      System.out.println("The factory returned " + food.getClass());
      System.out.println(food.getType());
    } catch (Exception e) {
      System.out.println("Unsuccessful Termination!!");
    }
  }
}
//Factory Method Pattern allows the sub-classes to choose the type of objects to create. It promotes the loose-coupling by eliminating the need to bind application-specific classes into the code.
//The factory design pattern is used when we have a superclass with multiple sub-classes and based on input, we need to return one of the sub-class. This pattern takes out the responsibility of the instantiation of a class from the client program to the factory class.
//A Factory Pattern or Factory Method Pattern says that just define an interface or abstract class for creating an object but let the subclasses decide which class to instantiate. In other words, subclasses are responsible to create the instance of the class.
/*The Factory Method Pattern is also known as Virtual Constructor.
Advantage of Factory Design Pattern
Factory Method Pattern allows the sub-classes to choose the type of objects to create.
It promotes the loose-coupling by eliminating the need to bind application-specific classes into the code. That means the code interacts solely with the resultant interface or abstract class, so that it will work with any classes that implement that interface or that extends that abstract class.

A Factory Pattern or Factory Method Pattern says that just define an interface or abstract class for creating an object but let the subclasses decide which class to instantiate. In other words, subclasses are responsible to create the instance of the class.

The Factory Method Pattern is also known as Virtual Constructor.

Advantage of Factory Design Pattern
Factory Method Pattern allows the sub-classes to choose the type of objects to create.
It promotes the loose-coupling by eliminating the need to bind application-specific classes into the code. That means the code interacts solely with the resultant interface or abstract class, so that it will work with any classes that implement that interface or that extends that abstract class.
*/
