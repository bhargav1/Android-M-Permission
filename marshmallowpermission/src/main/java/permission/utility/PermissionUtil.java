package permission.utility;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v7.app.AlertDialog;

import java.util.List;

/**
 * Created by bhargavsuthar on 9/22/15.
 */
public class PermissionUtil {


    public static List<String> getListOfGrantedPermission(){
        return null;
    }

    public static List<String> getListOfNotGrandtedPermission() {
        return null;
    }

    public static boolean verifyPermissions(int[] grantResults) {
        for (int result : grantResults) {
            if (result != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }

    @TargetApi(23)
    public static boolean hasSelfPermission(Activity activity, String[] permissions) {
        if (!isMNC()) {
            return true;
        }

        for (String permission : permissions) {
            if (activity.checkSelfPermission(permission) != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }

        return true;
    }

    @TargetApi(23)
    public static boolean hasSelfPermission(Activity activity, String permission) {
        if (!isMNC()) {
            return true;
        }
        return activity.checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED;
    }

    public static boolean isMNC() {
        return "MNC".equals(Build.VERSION.CODENAME) || Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1;
    }

    public static void showMessageOKCancel(Activity activity, String message, DialogInterface.OnClickListener okListener) {
        new AlertDialog.Builder(activity)
                .setMessage(message)
                .setPositiveButton("OK", okListener)
                .setNegativeButton("Cancel", null)
                .create()
                .show();
    }

}
