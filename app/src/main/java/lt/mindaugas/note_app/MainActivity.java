package lt.mindaugas.note_app;

import android.os.Bundle;

import lt.mindaugas.note_app.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity {
    private String message = "Sveikas Pasauli!!!!!! ☻";
    private int result = 0;
    private ActivityMainBinding binding;
    public final String TAG_MAIN_ACTIVITY = "Lifecycle_main_activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        super.setActivityName("Main Activity");
        super.setTagName(TAG_MAIN_ACTIVITY);
        super.printLogInfo("Create");

        setUpWidgets();
        clickOnButtonSum();

    }

    private void setUpWidgets() {
        binding.main.setBackgroundColor(getColor(R.color.navy));
        binding.editText01.setTextSize(30f);
        binding.editText01.setTextColor(getColor(R.color.yellow));
        binding.editText01.setText("0");
        binding.editText02.setTextSize(30f);
        binding.editText02.setTextColor(getColor(R.color.yellow));
        binding.editText02.setText("0");
        binding.resultTextView.setTextColor(getColor(R.color.yellow));
        binding.resultTextView.setTextSize(60f);
        binding.resultTextView.setText(String.valueOf(result));
    }

    private void clickOnButtonSum() {
        binding.sumButton.setOnClickListener(
                view -> {
                    result = Integer.parseInt(binding.editText01.getText().toString()) +
                            Integer.parseInt(binding.editText02.getText().toString());
                    binding.resultTextView.setText(String.valueOf(result));
                }
        );
    }
}