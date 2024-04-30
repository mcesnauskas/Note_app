package lt.mindaugas.note_app;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        final TextView textViewHello = findViewById(R.id.textViewHello);
        final View constraintLayout = findViewById(R.id.main);

        constraintLayout.setBackgroundColor(getColor(R.color.yellow));
        textViewHello.setTextSize(30f);
        textViewHello.setTextColor(getColor(R.color.navy));
        textViewHello.setText("Sveikas Pasauli!!!!!! ☻");

    }
}