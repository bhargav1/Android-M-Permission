package permissiondemo;

import android.Manifest;
import android.content.pm.PackageManager;
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
public class CameraAccessPermissionFragment extends PermissionFragment {

    private static final int REQUEST_CODE_PERMISSION = 123;

    public static CameraAccessPermissionFragment newInstance(){
        return  new CameraAccessPermissionFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_demo, container, false);
        boolean isPermissionGranted = PermissionUtil.hasSelfPermission(getActivity(), Manifest.permission.CAMERA);
        if(!isPermissionGranted) {
            requestPermissions(new String[]{Manifest.permission.CAMERA}, REQUEST_CODE_PERMISSION);
        } else {
            ((TextView) rootView.findViewById(R.id.section_label)).setText("Permission Granted already");
        }
        return rootView;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE_PERMISSION:
                if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    ((TextView) getActivity().findViewById(R.id.section_label)).setText("Now Permission Granted");
                }
                //Todo next case
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }
}
