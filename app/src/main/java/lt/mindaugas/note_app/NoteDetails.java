package lt.mindaugas.note_app;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lt.mindaugas.note_app.databinding.ActivityNoteDetailsBinding;
import lt.mindaugas.note_app.local_repository.MainDatabase;
import lt.mindaugas.note_app.util.Util;

public class NoteDetails extends AppCompatActivity {

    private ActivityNoteDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNoteDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int noteId = getIntent().getIntExtra(MainActivity.INTENT_NOTE_ID, -1);

        Note note = fetchNoteById(noteId);

        displayNoteDetails(note);
        clickOnButtonCancel();
        clickOnButtonDelete(note);
        clickOnButtonSave(note);
    }

    private Note fetchNoteById(int noteId){

        if (noteId <= 0) return new Note();

        Note note = MainDatabase.getInstance().noteDao().getById(noteId);

        if (note == null){
            note = new Note();
        }

        return note;
    }

    private void clickOnButtonCancel() {
        binding.cancelButton.setOnClickListener(
                view -> finish()
        );
    }

    private void clickOnButtonDelete(Note note) {
        binding.deleteButton.setOnClickListener(
                view -> {
                    if (note.getId() > 0){
                        MainDatabase.getInstance().noteDao().delete(note);
                        finish();
                    }
                }
        );
    }

    private void clickOnButtonSave(Note note) {
        binding.saveButton.setOnClickListener(
                view -> {
                    if (note.getId() > 0) {
                        note.setTitle(binding.noteTitleEditText.getText().toString());
                        note.setDescription(binding.noteDescriptionEditText.getText().toString());
//                        binding.noteUpdateDateTextView.setText(
//                                "Updated: " + displayDate(note.getUpdateDate())
//                        );
                        saveNoteAndCloseActivity(note);
                    } else {
                        Note newNote = new Note(
                                binding.noteTitleEditText.getText().toString(),
                                binding.noteDescriptionEditText.getText().toString()
                        );
                        saveNoteAndCloseActivity(newNote);
                    }
                }
        );
    }

    private void saveNoteAndCloseActivity(Note note) {
        MainDatabase.getInstance().noteDao().insertNote(note);
        finish();
    }

    private void displayNoteDetails(Note note) {
        if (note == null) return;
        if (note.getId() > 0){
            binding.noteIdTextView.setText(String.valueOf(note.getId()));
            binding.noteTitleEditText.setText(note.getTitle());
            binding.noteDescriptionEditText.setText(note.getDescription());
            binding.noteCreationDateTextView.setText(
                    getString(R.string.createdDate, Util.formatDateAndTime(note.getCreationDate()))
            );
            binding.noteUpdateDateTextView.setText(
                    getString(R.string.updatedDate, Util.formatDateAndTime(note.getUpdateDate()))
            );
        }
    }



}