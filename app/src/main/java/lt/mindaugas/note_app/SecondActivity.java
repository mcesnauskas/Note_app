package lt.mindaugas.note_app;

import android.os.Bundle;

import androidx.annotation.NonNull;

import lt.mindaugas.note_app.databinding.ActivitySecondBinding;

public class SecondActivity extends BaseActivity {
    private int result = 0;
    private ActivitySecondBinding binding;
    private static final String SAVE_KEY = "save_key";
    public static final String TAG_SECOND_ACTIVITY = "lifeCycle_second_activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        super.setActivityName("Second Activity");
        super.setTagName(TAG_SECOND_ACTIVITY);
        super.printLogInfo("Create");
        result = getIntent().getIntExtra(MainActivity.INTENT_RESULT_KEY, 0);

        setUpWidgets();
        clickOnButtonClose();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        result = Integer.parseInt(binding.resultTextView.getText().toString());
        outState.putInt(SAVE_KEY, result);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        result = savedInstanceState.getInt(SAVE_KEY);
        binding.resultTextView.setText(String.valueOf(result));
    }

    private void setUpWidgets() {
        binding.main.setBackgroundColor(getColor(R.color.navy));
        binding.resultTextView.setTextColor(getColor(R.color.yellow));
        binding.resultTextView.setTextSize(60f);
        binding.resultTextView.setText(String.valueOf(result));
    }

    private void clickOnButtonClose() {
        binding.closeButton.setOnClickListener(
                view -> {
                    finish();
                }
        );
    }
}