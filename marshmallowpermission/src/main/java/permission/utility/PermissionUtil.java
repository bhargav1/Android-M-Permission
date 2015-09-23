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


    /**
     * Get list of granted permission.
     *
     * @param activity the activity
     * @param permissions the permissions
     * @return the list
     */
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

    /**
     * Gets list of not grandted permission.
     *
     * @param activity the activity
     * @param permissions the permissions
     * @return the list of not grandted permission
     */
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

    /**
     * Verify permissions.
     *
     * @param grantResults the grant results
     * @return the boolean
     */
    public static boolean verifyPermissions(int[] grantResults) {
        for (int result : grantResults) {
            if (result != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }

    /**
     * This method check the list of multiple permissions has been granted or not. If all permission
     * has granted then it will return true else any one of the permission
     * not granted then it will return false.
     *
     * @param mActivity the m activity
     * @param permissions the permissions
     * @return the boolean
     */
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

    /**
     * This method check a single permission which already granted or not.
     *
     * @param mActivity the m activity
     * @param permission the permission
     * @return the boolean
     */
    public static boolean hasSelfPermission(Activity mActivity, String permission) {
        if (!isMNC()) {
            return true;
        }
        return mActivity.checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED;
    }

    /**
     * This method check wheather Android version is MNC or above LOLLIPOP_MR1.
     *
     * @return the boolean
     */
    public static boolean isMNC() {
        return "MNC".equals(Build.VERSION.CODENAME) || Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1;
    }

    /**
     * This method use to display the message on the screen.
     *
     * @param activity the activity
     * @param message the message
     * @param okListener the ok listener
     */
    public static void showMessageOKCancel(Activity activity, String message, DialogInterface.OnClickListener okListener) {
        new AlertDialog.Builder(activity)
                .setMessage(message)
                .setPositiveButton("OK", okListener)
                .setNegativeButton("Cancel", null)
                .create()
                .show();
    }

    /**
     * Get permission string array from the List.
     *
     * @param mPermissionList the m permission list
     * @return the string [ ]
     */
    public static String[] getPermissionStringArray(List<String> mPermissionList) {
        return mPermissionList.toArray(new String[mPermissionList.size()]);
    }

    /**
     * Add permission method is checking wheather current permission is already granted or not.
     * If its already granted then its not adding to the list.
     *
     * @param permissionsList the permissions list
     * @param permission the permission
     * @param activity the activity
     * @return the list
     */
    public static List<String> addPermission(List<String> permissionsList, String permission, Activity activity) {
        if (isMNC()) {
            if (activity.checkSelfPermission(permission) != PackageManager.PERMISSION_GRANTED) {
                permissionsList.add(permission);
            }
        }
        return  permissionsList;
    }

    /**
     * This will check wheather current permission is granted or not.
     *
     * @param mActivity the m activity
     * @param permission the permission
     * @return the boolean
     */
    public static boolean isPermissionGranted(Activity mActivity, String permission) {
        if (!isMNC()) {
            return true;
        }
        if(mActivity.checkSelfPermission(permission) != PackageManager.PERMISSION_GRANTED) {
            return false;
        }
        return true;
    }

    /**
     * Check for request permission rationale.
     *
     * @param activity the activity
     * @param permission the permission
     * @return the boolean
     */
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
