package lt.mindaugas.note_app;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import lt.mindaugas.note_app.databinding.ActivityMainBinding;
import lt.mindaugas.note_app.local_repository.MainDatabase;
import lt.mindaugas.note_app.local_repository.NoteDao;
import lt.mindaugas.note_app.local_repository.Repository;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private ArrayAdapter<Note> adapter;
    private List<Note> notes;
    private NoteDao noteDao;
    public static final String INTENT_NOTE_ID = "noteId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        notes = new ArrayList<>();

        setUpListView();
        clickOnItem();
        longClickOnItem();
        clickOnFab();
    }

    @Override
    protected void onStart() {
        super.onStart();
        getNotesFromLocalRepository();
        adapter.notifyDataSetChanged();
    }

    private void getNotesFromLocalRepository() {
        noteDao = MainDatabase.getInstance().noteDao();

        if (noteDao.getAll().isEmpty()) {
            noteDao.insertNotes(
                    Repository.getNotes(10)
            );
        }

        notes.clear();
        notes.addAll(noteDao.getAll());
    }

    private void setUpListView() {
        adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                notes
        );

        binding.notesListView.setAdapter(adapter);
    }

    private void clickOnItem() {
        binding.notesListView.setOnItemClickListener(
                (adapterView, view, i, l) -> {
                    Note note = (Note) adapterView.getItemAtPosition(i);
                    Intent intent = new Intent(MainActivity.this, NoteDetails.class);
                    intent.putExtra(INTENT_NOTE_ID, note.getId());
                    startActivity(intent);
                }
        );
    }

    private void clickOnFab() {
        binding.addNoteButton.setOnClickListener(
                view -> {
                    Intent intent = new Intent(MainActivity.this, NoteDetails.class);
                    startActivity(intent);
                }
        );
    }

    private void longClickOnItem() {
        binding.notesListView.setOnItemLongClickListener(
                (adapterView, view, i, l) -> {
                    showAlertDialogOnItemRemove(i);
                    return true;
                }
        );
    }

    private void showAlertDialogOnItemRemove(int position) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog
                .setTitle("Remove note")
                .setMessage("Are you sure you want to remove this note?")
                .setPositiveButton(
                        "Yes",
                        (dialogInterface, i) -> {
                            Note note = notes.get(position);
                            notes.removeIf(item -> item.getId() == note.getId());
                            noteDao.delete(note);
                            adapter.notifyDataSetChanged();
                        }
                )
                .setNegativeButton(
                        "No",
                        (dialogInterface, i) -> {
                            dialogInterface.dismiss();
                        }
                )
                .show();
    }

    private void showSnackBar(String message) {
//            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        Snackbar
                .make(binding.notesListView, message, Snackbar.LENGTH_LONG)
                .setActionTextColor(getColor(R.color.yellow))
                .setAction(
                        "OK",
                        v -> {
                            Toast
                                    .makeText(this, "Ok clicked", Toast.LENGTH_SHORT)
                                    .show();
                        }
                )
                .show();
    }
}

