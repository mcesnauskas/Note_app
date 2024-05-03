package lt.mindaugas.note_app;

import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {
    private String activityName = "[No Activity Name!!!]";
    private String tageName = "[LifeCycle_default_tag]";

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public void setTagName(String tageName) {
        this.tageName = tageName;
    }

    public final void printLogInfo(String message) {
        String line = "==================";
        Log.i(
                tageName,
                line + '\n' + activityName + ": on" + message + '\n' + line
        );
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        printLogInfo("Restart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        printLogInfo("Start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        printLogInfo("Resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        printLogInfo("Pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        printLogInfo("Stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        printLogInfo("Destroy");
    }
}
