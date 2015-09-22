package permission.state;

import java.util.List;

/**
 * Created by bhargavsuthar on 9/22/15.
 */
public class PermissionState {

    public List<String> grantedPermissionList;
    public List<String> notGrantedPermissionList;

    public List<String> getNotGrantedPermissionList() {
        return notGrantedPermissionList;
    }

    public void setNotGrantedPermissionList(List<String> notGrantedPermissionList) {
        this.notGrantedPermissionList = notGrantedPermissionList;
    }

    public List<String> getGrantedPermissionList() {
        return grantedPermissionList;
    }

    public void setGrantedPermissionList(List<String> grantedPermissionList) {
        this.grantedPermissionList = grantedPermissionList;
    }
}
