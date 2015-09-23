package permissiondemo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.domo.permissiondemo.R;

/**
 * Created by bhargavsuthar on 9/22/15.
 */
public class InternetPermissionFragment extends PermissionFragment {

    public static InternetPermissionFragment newInstance() {
        return new InternetPermissionFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_demo, container, false);
        return rootView;
    }
}
