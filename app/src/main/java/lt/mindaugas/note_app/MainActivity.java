package lt.mindaugas.note_app;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import lt.mindaugas.note_app.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        ArrayAdapter<Note> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                Repository.getNotes(20)
        );

        binding.notesListView.setAdapter(adapter);
    }
}