package algorithms;

import java.io.IOException;

/*Given a time in 12-hour AM/PM format, convert it to military (24-hour) time.

Note: - 12:00:00AM on a 12-hour clock is 00:00:00 on a 24-hour clock.
      - 12:00:00PM on a 12-hour clock is 12:00:00 on a 24-hour clock.*/

class ConvertTime {

  public static String timeConversion(String s) {
    String[] parts = s.split(":");
    String period = parts[2].substring(parts[2].length() - 2);
    String timePart = parts[2].substring(0, parts[2].length() - 2);

    int hours = Integer.parseInt(parts[0]);
    int minutes = Integer.parseInt(parts[1]);
    int seconds = Integer.parseInt(timePart);
    if (period.equalsIgnoreCase("PM") && hours != 12) {
      hours += 12;
    } else if (period.equalsIgnoreCase("AM") && hours == 12) {
      hours = 0;
    }

    return String.format("%02d:%02d:%02d", hours, minutes, seconds);
  }
}

public class Time_Conversion {

  public static void main(String[] args) throws IOException {
    //        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    //        String s = bufferedReader.readLine();
    String s = "07:05:45PM";
    String result = ConvertTime.timeConversion(s);
    System.out.println(result);
    //        bufferedReader.close();
  }
}
