package lt.mindaugas.note_app.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import lt.mindaugas.note_app.Note;
import lt.mindaugas.note_app.R;

public class NoteAdapter extends ArrayAdapter<Note> {
    private final LayoutInflater inflater;

    public NoteAdapter(Context context, List<Note> notes) {
        super(context, R.layout.note_details, notes);
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.note_details, parent, false);
            holder = new ViewHolder();
            holder.id = convertView.findViewById(R.id.itemIdTextView);
            holder.title = convertView.findViewById(R.id.itemTitleTextView);
            holder.updateDate = convertView.findViewById(R.id.itemUpdateDateTextView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Note note = getItem(position);
        if (note != null){
            holder.id.setText(String.valueOf(note.getId()));
            holder.title.setText(note.getTitle());
            holder.updateDate.setText(note.getUpdateDate().toString());
        }

        return convertView;
    }

}
