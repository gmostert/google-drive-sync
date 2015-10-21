package mostert.gerhard.googledrivesync.domain;

import java.util.Date;

/**
 * Created by CreepinDeath on 2014/12/30.
 */
public class Folder {

    private String localFolder;
    private String googleDriveFolder;
    private Date lastModified;

    public String getLocalFolder() {
        return localFolder;
    }

    public void setLocalFolder(String localFolder) {
        this.localFolder = localFolder;
    }

    public String getGoogleDriveFolder() {
        return googleDriveFolder;
    }

    public void setGoogleDriveFolder(String googleDriveFolder) {
        this.googleDriveFolder = googleDriveFolder;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

}
