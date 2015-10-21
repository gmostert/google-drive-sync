package mostert.gerhard.googledrivesync.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import mostert.gerhard.googledrivesync.R;
import mostert.gerhard.googledrivesync.domain.Folder;

/**
 * Created by CreepinDeath on 2014/12/30.
 */
public class FolderArrayAdapter extends ArrayAdapter<Folder> {

    private final List<Folder> list;
    private final Activity context;

    public FolderArrayAdapter(Activity context, List<Folder> list) {
        super(context, R.layout.folder_list_view, list);
        this.context = context;
        this.list = list;
    }

    static class ViewHolder {
        protected TextView localFolder;
        protected TextView lastModified;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;
        if (convertView == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            view = inflater.inflate(R.layout.folder_list_view, null);
            final ViewHolder viewHolder = new ViewHolder();
            viewHolder.localFolder = (TextView) view.findViewById(R.id.localFolder);
            viewHolder.lastModified = (TextView) view.findViewById(R.id.lastModified);
            view.setTag(viewHolder);
        } else {
            view = convertView;
        }

        ViewHolder holder = (ViewHolder) view.getTag();
        holder.localFolder.setText(list.get(position).getLocalFolder());
        holder.lastModified.setText(list.get(position).getLastModified().toString());

        return view;
    }
}