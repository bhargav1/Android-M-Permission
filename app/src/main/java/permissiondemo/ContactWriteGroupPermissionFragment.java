package permissiondemo;

import android.Manifest;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.domo.permissiondemo.R;

import permission.utility.PermissionUtil;


/**
 * Created by bhargavsuthar on 9/22/15.
 */
public class ContactWriteGroupPermissionFragment extends PermissionFragment {

    private static final int REQUEST_PERMISSION_GROUP = 111;

    public static ContactWriteGroupPermissionFragment newInstance(){
        return  new ContactWriteGroupPermissionFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_demo, container, false);
        boolean isGrantedPermission = PermissionUtil.hasSelfPermission(getActivity(), new String[]{Manifest.permission_group.CONTACTS});
        if(!isGrantedPermission){
            requestPermissions(new String[]{Manifest.permission_group.CONTACTS}, REQUEST_PERMISSION_GROUP);
        } else {
            ((TextView)rootView.findViewById(R.id.section_label)).setText("Group of Contact permissions already granted !!!");
        }
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


