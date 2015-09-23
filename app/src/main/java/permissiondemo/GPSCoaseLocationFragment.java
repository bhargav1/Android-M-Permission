package permissiondemo;

import android.Manifest;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.domo.permissiondemo.R;

import java.util.ArrayList;
import java.util.List;

import permission.utility.PermissionUtil;


/**
 * Created by bhargavsuthar on 9/22/15.
 */
public class GPSCoaseLocationFragment extends PermissionFragment {
    private static final int REQUEST_PERMISSION_GROUP = 222;

    public static GPSCoaseLocationFragment newInstance() {
        return new GPSCoaseLocationFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_demo, container, false);

        List<String> mPermissions = new ArrayList<String>();
        mPermissions.add(Manifest.permission.ACCESS_COARSE_LOCATION);
        mPermissions.add(Manifest.permission.ACCESS_FINE_LOCATION);
        mPermissions.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);

        List<String> notGrantedList = PermissionUtil.getListOfNotGrandtedPermission(getActivity(), mPermissions);
        if(notGrantedList != null && notGrantedList.size() > 0){
            requestPermissions(PermissionUtil.getPermissionStringArray(notGrantedList), REQUEST_PERMISSION_GROUP);
        }
        return rootView;
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        //Todo handle when user agree with permission
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
