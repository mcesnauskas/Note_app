package lt.mindaugas.note_app;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import lt.mindaugas.note_app.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.main.setBackgroundColor(getColor(R.color.yellow));
        binding.textViewHello.setTextSize(30f);
        binding.textViewHello.setTextColor(getColor(R.color.navy));
        binding.textViewHello.setText("Sveikas Pasauli!!!!!! ☻");

    }
}