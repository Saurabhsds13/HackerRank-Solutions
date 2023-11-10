package dataStructures;
// Sort by the Score of the students.
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Checker implements Comparator<Player>{
    
  
    public int compare(Player a,Player b) {
        Player p1=(Player)a;
        Player p2=(Player)b;
            if(p1.score==p2.score)  
    return a.name.compareTo(b.name);  // If score is same then compare it by their names alphabetically.
    else if(p1.score<p2.score)  
    return 1;  
    else  
    return -1;
        }   
   }

	class Player{
	    String name;
	    int score;
	    
	    Player(String name, int score){
	        this.name = name;
	        this.score = score;
	    }
	}

	class JavaComparator {

	    public static void main(String[] args) {
	        Scanner scan = new Scanner(System.in);
	        System.out.println("Enter the No of player's : ");
	        int n = scan.nextInt();

	        Player[] player = new Player[n];
	        Checker checker = new Checker();
	        System.out.println("\nEnter the Name and Score's of the Player's : ");
	        for(int i = 0; i < n; i++){
	            player[i] = new Player(scan.next(), scan.nextInt());
	        }
	        scan.close();

	        Arrays.sort(player, checker);
	        for(int i = 0; i < player.length; i++){
	            System.out.printf("%s %s\n\n", player[i].name, player[i].score);
	        }
	    }
}