package mostert.gerhard.googledrivesync;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import mostert.gerhard.googledrivesync.util.DirectoryChooserDialog;


public class AddFolderActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_folder);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_folder, menu);
        return true;
    }

    public void chooseLocalFolder(View view) {
        DirectoryChooserDialog directoryChooserDialog = new DirectoryChooserDialog(AddFolderActivity.this,
            new DirectoryChooserDialog.ChosenDirectoryListener() {
                @Override
                public void onChosenDir(String chosenDir) {
                    Toast.makeText(AddFolderActivity.this, "Chosen directory: " + chosenDir, Toast.LENGTH_LONG).show();
                    TextView localFolderTextView = (TextView) findViewById(R.id.localFolder);
                    localFolderTextView.setText(chosenDir);
                }
            }
        );

        directoryChooserDialog.setNewFolderEnabled(true);
        directoryChooserDialog.chooseDirectory("");
    }
}
