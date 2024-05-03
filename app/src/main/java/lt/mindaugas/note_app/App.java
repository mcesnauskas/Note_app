package lt.mindaugas.note_app;

import android.app.Application;
import android.content.Context;

import java.lang.ref.WeakReference;

import lombok.Getter;

@Getter
public class App extends Application {
    private static WeakReference<Context> instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = new WeakReference<>(getApplicationContext());
    }

    public static Context getContext() {
        return instance.get();
    }
}
