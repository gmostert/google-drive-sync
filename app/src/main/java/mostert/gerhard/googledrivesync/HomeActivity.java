package mostert.gerhard.googledrivesync;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import mostert.gerhard.googledrivesync.adapter.FolderArrayAdapter;
import mostert.gerhard.googledrivesync.domain.Folder;


public class HomeActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);

        ListView folderListView = (ListView) findViewById(R.id.folderListView);
        FolderArrayAdapter folderArrayAdapter = new FolderArrayAdapter(this, getModel());
        folderListView.setAdapter(folderArrayAdapter);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void addFolder(View view) {
        Intent intent = new Intent(this, AddFolderActivity.class);
        startActivity(intent);
    }

    private List<Folder> getModel() {
        Folder folder1 = new Folder();
        folder1.setLocalFolder("Test");
        folder1.setGoogleDriveFolder("Drive/Test");
        folder1.setLastModified(new Date());

        List<Folder> list = new ArrayList<Folder>();
        list.add(folder1);

        return list;
    }
}
