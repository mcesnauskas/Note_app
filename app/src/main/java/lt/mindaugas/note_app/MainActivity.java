package lt.mindaugas.note_app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

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
                    Note note = (Note) adapterView.getItemAtPosition(i);
                    String message = String.format("Clicked on note with id %s", note.getId());
                    Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
                }
        );
    }
}
