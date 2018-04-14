package app.mediaapplication.helper;

import android.media.MediaMetadataRetriever;
import android.util.Log;

import java.io.File;

public class MediaHelper {

    public static String getDuration(File file) {
        String ret = null;
        try {
            Log.d("zhq.debug", "path " + file.getAbsolutePath());
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(file.getAbsolutePath());
            ret = mediaMetadataRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION);
        } catch (Exception e) {
            Log.d("zhq.debug", "getDuration error :" + e.toString());
        }
        return ret;
    }
}
