package lt.mindaugas.note_app;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Data
@ToString
public class Note implements Parcelable {
    private int id;
    private String title;
    private String description;
    private LocalDateTime creationDate;
    private LocalDateTime updateDate;

    public Note(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.creationDate = LocalDateTime.now();
        this.updateDate = LocalDateTime.now();
    }

    protected Note(Parcel in) {
        id = in.readInt();
        title = in.readString();
        description = in.readString();
    }

    public static final Creator<Note> CREATOR = new Creator<Note>() {
        @Override
        public Note createFromParcel(Parcel in) {
            return new Note(in);
        }

        @Override
        public Note[] newArray(int size) {
            return new Note[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(title);
        dest.writeString(description);
    }
}


