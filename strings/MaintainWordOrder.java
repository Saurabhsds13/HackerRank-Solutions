package strings;

public class MaintainWordOrder {

  public static void main(String[] args) {
	   	
    String s = "This is a really simple sentence";
    String[] words = s.split(" ");
    
    StringBuilder reversedSentence = new StringBuilder();
    
    for (String word : words) {

      StringBuilder reverseWords = new StringBuilder(word);
      reverseWords.reverse();
      reversedSentence.append(reverseWords).append(" ");
      reversedSentence.toString().trim();
    }
    
    System.out.print(reversedSentence);
  }
}