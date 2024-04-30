package lt.mindaugas.note_app;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import lt.mindaugas.note_app.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private ArrayAdapter<Note> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setUpListView();
        clickOnItem(this);
        longClickOnItem();
    }

    private void setUpListView() {
        adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                Repository.getNotes(20)
        );

        binding.notesListView.setAdapter(adapter);
    }

    private void clickOnItem(Context context) {
        binding.notesListView.setOnItemClickListener(
                (adapterView, view, i, l) -> {
                    Log.i("my_tst", "clickOnItem");
                    Note note = (Note) adapterView.getItemAtPosition(i);
                    String message = String.format("Clicked on note with id %s", note.getId());

                    showSnackBar(message);
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
                            Repository.list.remove(position);
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

