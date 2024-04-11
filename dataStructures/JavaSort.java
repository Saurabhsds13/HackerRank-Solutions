package dataStructures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/*
 You are given a list of student information: ID, FirstName, and CGPA. Your task is to rearrange them according to their CGPA in decreasing order. If two student have the same CGPA, then arrange them according to their first name in alphabetical order. If those two students also have the same first name, then order them according to their ID. No two students have the same ID.
Hint: You can use comparators to sort a list of objects. See the oracle doc to learn about comparators.
Input Format :-
The first line of input contains an integer N, representing the total number of students. The next N lines contains a list of student information in the following structure: ID Name CGPA
Output Format :-
After rearranging the students according to the above rules, print the first name of each student on a separate line.
*/

class Student {
  private int id;
  private String fname;
  private double cgpa;

  protected Student(int id, String fname, double cgpa) {
    super();
    this.id = id;
    this.fname = fname;
    this.cgpa = cgpa;
  }

  public int getId() {
    return id;
  }

  public String getFname() {
    return fname;
  }

  public double getCgpa() {
    return cgpa;
  }
}

/*
Parameters:
s1 - the first object to be compared.
s2 - the second object to be compared.
Returns:
 - = Less;
 0 = Equal;
 + = Greater;
a NEGATIVE integer, ZERO, or a POSITIVE integer as the first argument is LESS than, EQUAL to, or GREATER than the second.
*/
class studentComparator implements Comparator<Student> {

  public int compare(Student s1, Student s2) {
    if (s1.getCgpa() != s2.getCgpa()) {
      return Double.compare(s2.getCgpa(), s1.getCgpa());
    } else if (!s1.getFname().equals(s2.getFname())) {
      return s1.getFname().compareTo(s2.getFname());
    } else return Integer.compare(s1.getId(), s2.getId());
  }
}

public class JavaSort {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println("Enter No of Test cases :- ");
    int testCases = Integer.parseInt(in.nextLine());

    List<Student> studentList = new ArrayList<>();
    System.out.println("\nEnter ID , NAME and CGPA :- ");

    while (testCases > 0) {
      int id = in.nextInt();
      String fname = in.next();
      double cgpa = in.nextDouble();

      Student st = new Student(id, fname, cgpa);
      studentList.add(st);
      testCases--;
    }

    Collections.sort(studentList, new studentComparator());

    System.out.println("\nSorted List by CGPA Ascending Order : ");

    for (Student st : studentList) {
      System.out.println(st.getFname());
    }
    in.close();
  }
}
