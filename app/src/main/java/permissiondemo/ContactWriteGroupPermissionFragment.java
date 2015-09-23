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
public class ContactWriteGroupPermissionFragment extends PermissionFragment {

    private static final int REQUEST_PERMISSION_GROUP = 132;

    public static ContactWriteGroupPermissionFragment newInstance() {
        return new ContactWriteGroupPermissionFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_demo, container, false);
        List<String> mPermissions = new ArrayList<String>();
        mPermissions.add(Manifest.permission.READ_CONTACTS);
        mPermissions.add(Manifest.permission.CAMERA);
        mPermissions.add(Manifest.permission.WRITE_CONTACTS);

        List<String> notGrantedList = PermissionUtil.getListOfNotGrandtedPermission(getActivity(), mPermissions);

        requestPermissions(notGrantedList.toArray(new String[notGrantedList.size()]), REQUEST_PERMISSION_GROUP);

        return rootView;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case REQUEST_PERMISSION_GROUP:
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
                break;
        }

    }
}


