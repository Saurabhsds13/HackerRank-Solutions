package algorithms;

import java.util.ArrayList;
import java.util.List;

/* You are in charge of the cake for a child's birthday. You have decided the cake will have one candle for each year of their total age. They will only be able to blow out the tallest of the candles. Count how many candles are tallest.  */

class Sol {

  static int birthdayCakeCandles(List<Integer> candles) {
    int[] candle = new int[candles.size()];

    for (int i = 0; i < candles.size(); i++) {
      candle[i] = candles.get(i);
    }

    int max = candle[0];
    int count = 1; //count is initialized to 1 because the first element is the largest we've seen so far.

    for (int i = 1; i < candle.length; i++) { //Iterate through the array starting from the second element.
      if (candle[i] > max) { //If the current element is greater than largestNumber, update largestNumber and reset count to 1.
        max = candle[i];
        count = 1;
      } else if (candle[i] == max) {
        count++; //If the current element equals largestNumber, increment count.
      }
    }
    return count;
  }
}

public class Birthday_Cake_Candles {

  public static void main(String[] args) {
    List<Integer> candles = new ArrayList<>();
    candles.add(3);
    candles.add(2);
    candles.add(1);
    candles.add(3);

    int result = Sol.birthdayCakeCandles(candles);
    System.out.println(result);
  }
}
/* More efficent way :-
   int max=candles.get(0);
        int count = 1;
        
        for(int i =1;i<candles.size();i++){
             int current=candles.get(i);
             
            if(current>max){
                max=current;
                count =1;
            }else if(current == max){
                count++;
            }
        }  
  return count;
 */
