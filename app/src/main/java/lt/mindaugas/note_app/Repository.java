package lt.mindaugas.note_app;

import java.util.ArrayList;
import java.util.List;

public class Repository {

    public static List<String> getDaysOfWeek(){
        ArrayList<String> list = new ArrayList<>();
        list.add("Monday");
        list.add("Tuesday");
        list.add("Wednesday");
        list.add("Thursday");
        list.add("Friday");
        list.add("Saturday");
        list.add("Sunday");

        return list;
    }

    public static List<String> getMonths(){
        ArrayList<String> list = new ArrayList<>();
        list.add("January");
        list.add("February");
        list.add("March");
        list.add("April");
        list.add("May");
        list.add("June");
        list.add("July");
        list.add("August");
        list.add("September");
        list.add("October");
        list.add("November");

        return list;
    }
}