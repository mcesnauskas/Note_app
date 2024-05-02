package lt.mindaugas.note_app;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import lt.mindaugas.note_app.databinding.ActivityNoteDetailsBinding;

public class NoteDetails extends AppCompatActivity {

    private ActivityNoteDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNoteDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int noteId = getIntent().getIntExtra(MainActivity.INTENT_NOTE_ID, -1);

    }
}