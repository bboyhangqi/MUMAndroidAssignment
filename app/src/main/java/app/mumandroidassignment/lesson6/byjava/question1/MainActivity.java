package app.mumandroidassignment.lesson6.byjava.question1;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import app.mumandroidassignment.R;

public class MainActivity extends AppCompatActivity {

    private final String FRAGMENT_HOME = "fragment_home";
    private final String FRAGMENT_ABOUT = "fragment_about";
    private final String FRAGMENT_WORK = "fragment_work";
    private final String FRAGMENT_CONTACT = "fragment_contact";

    private final Fragment fragmentHome = new HomeFragment();
    private final Fragment fragmentAbout = new AboutFragment();
    private final Fragment fragmentWork = new WorkFragment();
    private final Fragment fragmentContact = new ContactFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Curriculum Vitae");
        getSupportFragmentManager().beginTransaction().add(R.id.root, fragmentHome, FRAGMENT_HOME).commit();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_lesson6_1, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mi_home:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.root, fragmentHome, FRAGMENT_HOME)
                        .commit();
                break;
            case R.id.mi_Work:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.root, fragmentWork, FRAGMENT_WORK)
                        .commit();
                break;
            case R.id.mi_contact:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.root, fragmentContact, FRAGMENT_CONTACT)
                        .commit();
                break;
            case R.id.mi_about_me:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.root, fragmentAbout, FRAGMENT_ABOUT)
                        .commit();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
