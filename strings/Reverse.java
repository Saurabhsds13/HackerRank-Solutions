package strings;

 public class Reverse {
	
	
     static String reverseString(String input) {
    	
        // Check if the input string is null or empty
        if (input == null || input.isEmpty()) {
            return input;
        }
        
        // Convert the string to a character array
        char[] charArray = input.toCharArray();
        
        // Initialize pointers for the start and end of the character array
        int start = 0;
        int end = charArray.length - 1;
        
        // Iterate until the start pointer is less than the end pointer
        while (start < end) {
            // Swap characters at start and end positions
            char temp = charArray[start];
            charArray[start] = charArray[end];
            charArray[end] = temp;
            
            // Move the pointers towards each other
            start++;
            end--;
        }
        
        // Convert the character array back to a string
        return new String(charArray);
    }
     
    
    public static void main(String[] args) {
        String input = "Hello, world!";
        String reversed = reverseString(input);
        System.out.println("Original: " + input);
        System.out.println("Reversed: " + reversed);
    }
}


