package dataStructures;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

class Students {
  private int Id;
  private String Name;
  private double CGPA;

  protected Students(int id, String name, double cgpa) {
    super();
    this.Id = id;
    this.Name = name;
    this.CGPA = cgpa;
  }

  public int getId() {
    return Id;
  }

  public String getName() {
    return Name;
  }

  public double getCgpa() {
    return CGPA;
  }
}

class Priorities {

  List<Students> getStudents(List<String> events) {
    PriorityQueue<Students> pq = new PriorityQueue<>(
      (s1, s2) -> {
        if (Double.compare(s2.getCgpa(), s1.getCgpa()) != 0) return Double.compare(
          s2.getCgpa(),
          s1.getCgpa()
        ); else if (!s1.getName().equals(s2.getName())) return s1
          .getName()
          .compareTo(s2.getName()); else return Integer.compare(s1.getId(), s2.getId());
      }
    );

    for (String event : events) {
      String[] parts = event.split(" ");
      if (parts[0].equals("ENTER")) {
        String name = parts[1];
        double cgpa = Double.parseDouble(parts[2]);
        int id = Integer.parseInt(parts[3]);
        pq.offer(new Students(id, name, cgpa));
      } else if (parts[0].equals("SERVED")) {
        pq.poll();
      }
    }

    List<Students> result = new ArrayList<>();
    while (!pq.isEmpty()) {
      result.add(pq.poll());
    }

    return result;
  }
}

public class JavaPriorityQueue {
  private static final Scanner scan = new Scanner(System.in);
  private static final Priorities priorities = new Priorities();

  public static void main(String[] args) {
    int totalEvents = Integer.parseInt(scan.nextLine()); //12
    List<String> events = new ArrayList<>();

    while (totalEvents-- != 0) {
      String event = scan.nextLine();
      events.add(event); //  John 3.75 50
    }

    List<Students> students = priorities.getStudents(events);

    if (students.isEmpty()) {
      System.out.println("EMPTY");
    } else {
      for (Students st : students) {
        System.out.println(st.getName());
      }
    }
  }
}
/*In this case, the number of events is 12. Let the name of the queue be Q.

John is added to Q. So, it contains (John, 3.75, 50).
Mark is added to Q. So, it contains (John, 3.75, 50) and (Mark, 3.8, 24).
Saurabh is added to Q. So, it contains (John, 3.75, 50), (Mark, 3.8, 24), and (Saurabh, 3.7, 35).
Mark is served as he has the highest CGPA. So, Q contains (John, 3.75, 50) and (Saurabh, 3.7, 35).
John is served next as he has the highest CGPA. So, Q contains (Saurabh, 3.7, 35).
Meloni is added to Q. So, it contains (Saurabh, 3.7, 35) and (Meloni, 3.85, 36).
Meloni is served as she has the highest CGPA. So, Q contains (Saurabh, 3.7, 35).
Now, four more students are added to Q. So, it contains (Saurabh, 3.7, 35), (Ashley, 3.9, 42), (Maria, 3.6, 46), (Anik, 3.95, 49), and (Dan, 3.95, 50).
anik is served because though both anik and dan have the highest cgpa but anik comes first when sorted in alphabetic order. so, q contains (dan, 3.95, 50), (ashley, 3.9, 42), (Saurabh, 3.7, 35), and (maria, 3.6, 46).

INPUT :-
12
ENTER John 3.75 50
ENTER Mark 3.8 24
ENTER Saurabh 3.7 35
SERVED 	
SERVED
ENTER Meloni 3.85 36
SERVED
ENTER Ashley 3.9 42
ENTER Maria 3.6 46
ENTER Anik 3.95 49
ENTER Dan 3.95 50
SERVED

*
*/
