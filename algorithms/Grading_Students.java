package algorithms;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class ResultOfStudents {

  public static List<Integer> gradingStudents(List<Integer> grades) {
    List<Integer> roundedGrades = new ArrayList<>();

    for (int grade : grades) {
      if (grade < 38) {
        roundedGrades.add(grade);
      } else {
        int nextMultipleOf5 = ((grade / 5) + 1) * 5; // ((73/5)+1)*5 = 78
        System.out.println("nextMultipleOf5 is "+nextMultipleOf5);
        if (nextMultipleOf5 - grade < 3) {
          roundedGrades.add(nextMultipleOf5);
        } else {
          roundedGrades.add(grade);
        }
      }
    }
    return roundedGrades;
  }
}

public class Grading_Students {

  public static void main(String[] args) throws IOException {
    List<Integer> grades = new ArrayList<>();

    grades.add(73);
    grades.add(67);
    grades.add(38);
    grades.add(33);

    List<Integer> result = ResultOfStudents.gradingStudents(grades);

    for (int grade : result) {
      System.out.println(grade);
    }
  }
}
 
/*	Rounding Logic:
We iterate over each grade in the list.
If a grade is less than 38, it is added to the roundedGrades list as it is.
For grades 38 or higher, we calculate the next multiple of 5.
If the difference between this multiple and the original grade is less than 3, we add the rounded grade to the list.
Otherwise, we add the original grade.*/