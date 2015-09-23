package permission.utility;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v7.app.AlertDialog;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bhargavsuthar on 9/22/15.
 */
@TargetApi(23)
public class PermissionUtil {


    public static List<String> getListOfGrantedPermission(Activity activity, List<String> permissions){
        List<String> mGrantedPermissions = new ArrayList<String>();
        if(permissions.size() > 0){
            for(String mPermission : permissions){
                if(activity.checkSelfPermission(mPermission) == PackageManager.PERMISSION_GRANTED) {
                    mGrantedPermissions.add(mPermission);
                }
            }
        }
        return mGrantedPermissions;
    }

    public static List<String> getListOfNotGrandtedPermission(Activity activity, List<String> permissions) {
        List<String> mGrantedPermissions = new ArrayList<String>();
        if(permissions.size() > 0){
            for(String mPermission : permissions){
                if(activity.checkSelfPermission(mPermission) != PackageManager.PERMISSION_GRANTED) {
                    mGrantedPermissions.add(mPermission);
                }
            }
        }
        return mGrantedPermissions;
    }

    public static boolean verifyPermissions(int[] grantResults) {
        for (int result : grantResults) {
            if (result != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }

    public static boolean hasSelfPermission(Activity mActivity, String[] permissions) {
        if (!isMNC()) {
            return true;
        }

        for (String permission : permissions) {
            if (mActivity.checkSelfPermission(permission) != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }

        return true;
    }

    public static boolean hasSelfPermission(Activity mActivity, String permission) {
        if (!isMNC()) {
            return true;
        }
        return mActivity.checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED;
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

    public static String[] getPermissionStringArray(List<String> mPermissionList) {
        return mPermissionList.toArray(new String[mPermissionList.size()]);
    }

    public static List<String> addPermission(List<String> permissionsList, String permission, Activity activity) {
        if (isMNC()) {
            if (activity.checkSelfPermission(permission) != PackageManager.PERMISSION_GRANTED) {
                permissionsList.add(permission);
            }
        }
        return  permissionsList;
    }

    public static boolean isPermissionGranted(Activity mActivity, String permission) {
        if (!isMNC()) {
            return true;
        }
        if(mActivity.checkSelfPermission(permission) != PackageManager.PERMISSION_GRANTED) {
            return false;
        }
        return true;
    }

    public static boolean checkForRequestPermissionRationale(Activity activity, String permission) {
        if (!isMNC()) {
            return true;
        }
        if(!activity.shouldShowRequestPermissionRationale(permission)){
            return false;
        }
        return true;
    }

}
