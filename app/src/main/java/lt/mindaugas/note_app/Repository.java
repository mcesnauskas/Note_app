package lt.mindaugas.note_app;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

public class Repository {
    public static ArrayList<Note> list = new ArrayList<>();

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

    public static List<Note> getNotes(int itemNo){
        for (int i = 0; i < itemNo; i++) {
            list.add(new Note(
                    i+1,
                    "Note " + (i+1),
                    "Description " + (i+1)
            ));
        }

        return list;
    }

    public static Note getNoteById(int noteId){
        Note emptyNote = new Note();
        emptyNote.setId(-1);
        Note note = list
                .stream()
                .filter(item -> item.getId() == noteId)
                .findFirst()
                .orElse(emptyNote);
        return note;
    }
}
