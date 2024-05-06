package lt.mindaugas.note_app.local_repository;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import lt.mindaugas.note_app.App;
import lt.mindaugas.note_app.Note;

@Database(
        entities = {Note.class},
        version = MainDatabase.DATABASE_VERSION,
        exportSchema = false
)
@TypeConverters({Converter.class})
public abstract class MainDatabase extends RoomDatabase {

    public static final int PREVIOUS_VERSION = 1;
    public static final int DATABASE_VERSION = PREVIOUS_VERSION + 1;

    public static final String DATABASE_NAME = "main.db";

    private static MainDatabase instance;

    public static synchronized MainDatabase getInstance() {
        if (instance == null) {
            instance = Room.databaseBuilder(
                            App.getContext(),
                            MainDatabase.class,
                            DATABASE_NAME
                    )
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }

        return instance;
    }

    public abstract NoteDao noteDao();
}
