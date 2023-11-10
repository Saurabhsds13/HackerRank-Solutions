package dataStructures;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class JavaMap {

	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		String name;
		int phoneNo;
		System.out.println("Number of Entries you want to Add in Phonebook : ");
		int n = sc.nextInt();
		System.out.println("Enter Name and Number to Store : ");
		Map<String,Integer> phonebook = new HashMap<>();
		for(int i=0;i<=n;i++) {
			name= sc.next();
			sc.nextLine();
			phoneNo=sc.nextInt();
			phonebook.put(name, phoneNo);
		}
		
		System.out.println("Enter the name you want to search : ");
		String search= sc.next();
		
	if(phonebook.containsKey(search)) {
		Integer value = phonebook.get(search);
	    System.out.println("\n\t" + search + " : " + value);

	}else {
	    System.out.println("\n\tNot found");
	}
		sc.close();
	}
}
