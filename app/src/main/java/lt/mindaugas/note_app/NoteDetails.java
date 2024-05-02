package lt.mindaugas.note_app;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import lt.mindaugas.note_app.databinding.ActivityMainBinding;
import lt.mindaugas.note_app.databinding.ActivityNoteDetailsBinding;

public class NoteDetails extends AppCompatActivity {

    private ActivityNoteDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNoteDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String noteDetails = getIntent().getStringExtra("note");
        int noteId = getIntent().getIntExtra("note_id", 0);
        Note note = getIntent().getParcelableExtra("note_object");

        binding.noteIdTextView.setText(String.valueOf(noteId));
//        binding.noteDetailsTextView.setText(noteDetails);
        binding.noteDetailsTextView.setText(
                String.format("NoteID: %d\nTitle: %s\nDescription: %s",
                        note.getId(),
                        note.getTitle(),
                        note.getDescription()
                )
        );
    }

    private void showAlertDialog(String message) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog
                .setTitle("Notice")
                .setMessage(message)
                .setNegativeButton(
                        "Close",
                        (dialogInterface, i) -> {
                            dialogInterface.dismiss();
                        }
                )
                .show();
    }
}