package mobiquitypermissiondeom;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;

import com.mobiquity.mobiquitypermissiondemo.R;

public class DemoActivity extends AppCompatActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    private CharSequence mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();
        restoreActionBar(mTitle.toString());

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment newFragment = null;
        if(position == 0){
            newFragment = CameraAccessPermissionFragment.newInstance();
            restoreActionBar(getString(R.string.title_section1));
        } else if (position == 1) {
            newFragment = ContactPermissionFragment.newInstance();
            restoreActionBar(getString(R.string.title_section2));
        } else if (position == 2) {
            newFragment = ContactWriteGroupPermissionFragment.newInstance();
            restoreActionBar(getString(R.string.title_section3));
        } else if (position == 3) {
            newFragment = GPSCoaseLocationFragment.newInstance();
            restoreActionBar(getString(R.string.title_section4));
        } else if (position == 4) {
            newFragment = InternetPermissionFragment.newInstance();
            restoreActionBar(getString(R.string.title_section5));
        }
         fragmentManager.beginTransaction()
                .replace(R.id.container, newFragment)
                .commit();
    }

    public void restoreActionBar(String title) {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(title);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.demo, menu);
            //restoreActionBar(mTitle.toString());
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }
/*

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
*/

}
