package lt.mindaugas.note_app;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lt.mindaugas.note_app.databinding.ActivityNoteDetailsBinding;
import lt.mindaugas.note_app.local_repository.Repository;

public class NoteDetails extends AppCompatActivity {

    private ActivityNoteDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNoteDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int noteId = getIntent().getIntExtra(MainActivity.INTENT_NOTE_ID, -1);
        Note note = Repository.getNoteById(noteId);

        displayNoteDetails(note);
        clickOnButtonCancel();
        clickOnButtonDelete(note.getId());
        clickOnButtonSave();
    }

    private void clickOnButtonCancel() {
        binding.cancelButton.setOnClickListener(
                view -> finish()
        );
    }

    private void clickOnButtonDelete(int noteId) {
        binding.deleteButton.setOnClickListener(
                view -> {
                    if (noteId > 0){
                        Repository.deleteNoteById(noteId);
                        finish();
                    }
                }
        );
    }

    private void clickOnButtonSave() {
        binding.saveButton.setOnClickListener(
                view -> {

                }
        );
    }


    private void displayNoteDetails(Note note) {
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