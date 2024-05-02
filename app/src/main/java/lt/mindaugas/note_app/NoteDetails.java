package lt.mindaugas.note_app;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lt.mindaugas.note_app.databinding.ActivityNoteDetailsBinding;

public class NoteDetails extends AppCompatActivity {

    private ActivityNoteDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNoteDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int noteId = getIntent().getIntExtra(MainActivity.INTENT_NOTE_ID, -1);
        Note note = Repository.getNoteById(noteId);

        if (note.getId() > 0){
            binding.noteIdTextView.setText(String.valueOf(note.getId()));
            binding.noteTitleEditText.setText(note.getTitle());
            binding.noteDescriptionEditText.setText(note.getDescription());
            binding.noteCreationDateTextView.setText(
                    "Created: " + displayDate(note.getCreationDate())
            );
            binding.noteUpdateDateTextView.setText(
                    "Updated: " + displayDate(note.getUpdateDate())
            );
        }
    }

    private String displayDate(LocalDateTime date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return date != null ? date.format(formatter) : "no data";
    }

}