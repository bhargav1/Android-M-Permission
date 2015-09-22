package mobiquitypermissiondeom;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mobiquity.mobiquitypermissiondemo.R;

import permission.utility.PermissionUtil;


/**
 * Created by bhargavsuthar on 9/22/15.
 */
public class ContactPermissionFragment extends PermissionFragment {

    private final static int REQUEST_GROUP_PERMISSION = 234;

    public static ContactPermissionFragment newInstance(){
        return  new ContactPermissionFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_demo, container, false);
        boolean isPermissionGranted = PermissionUtil.hasSelfPermission(getActivity(), Manifest.permission.READ_CONTACTS);
        if(!isPermissionGranted){
            if(!shouldShowRequestPermissionRationale(Manifest.permission.READ_CONTACTS)){
                PermissionUtil.showMessageOKCancel(getActivity(), "You need to allow access to Contacts", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(which == DialogInterface.BUTTON_POSITIVE) {
                            //Todo on Ok button click
                            requestPermissions(new String[]{Manifest.permission.READ_CONTACTS}, REQUEST_GROUP_PERMISSION);
                            return;
                        }
                    }
                });
            }
            requestPermissions(new String[]{Manifest.permission.READ_CONTACTS}, REQUEST_GROUP_PERMISSION);
        } else {
            //Todo with result
            ((TextView) rootView.findViewById(R.id.section_label)).setText("Contact permission Granted already !!!!");
        }
        return rootView;
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case REQUEST_GROUP_PERMISSION:
                if(grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //Todo with first granted result
                    ((TextView) getActivity().findViewById(R.id.section_label)).setText("Now Contact permission grandted !!!");
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
                break;
        }

    }


}
