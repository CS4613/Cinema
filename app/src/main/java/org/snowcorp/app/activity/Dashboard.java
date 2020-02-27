package org.snowcorp.app.activity;


import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.snowcorp.app.R;
import org.snowcorp.app.fragment.MovieFragment;
import org.snowcorp.app.presenter.DashboardPresenter;
import org.snowcorp.app.utils.GlobalUtils;
import org.snowcorp.app.utils.HideKeyboard;
import org.snowcorp.app.view.DashboardView;


public class Dashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, DashboardView {

    public static NavigationView navigationView;
    private DrawerLayout drawer;
    private android.support.v7.app.ActionBarDrawerToggle toggle;
    private TextView txtUsername;
    private TextView txtEmail;
    private ImageView imgProfile;
    private DashboardPresenter presenter;
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_dashboard);
        new HideKeyboard(this).setupUI(findViewById(android.R.id.content));
        findViews();
        initToolbar();
        initSideMenu();
        GlobalUtils.addFragment(this, new MovieFragment(), R.id.container, false);
    }


    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        Log.d("MenuID", String.valueOf(id));

        if (id == R.id.iconSearch) {
            GlobalUtils.navigateActivity(this, false, SearchActivity.class);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        Log.d("MenuID", String.valueOf(id));
        presenter.onNavigationItemClicked(id);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void findViews() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        txtUsername = (TextView) navigationView.getHeaderView(0).findViewById(R.id.txtUsername);
        txtEmail = (TextView) navigationView.getHeaderView(0).findViewById(R.id.txtEmail);
        imgProfile = (ImageView) navigationView.getHeaderView(0).findViewById(R.id.imgProfile);
        txtUsername.setText(GlobalUtils.getFromPref("name", this));
        txtEmail.setText(GlobalUtils.getFromPref("email", this));
        presenter = new DashboardPresenter(this, this);

    }


    @Override
    public void initToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    @Override
    public void initSideMenu() {
        toggle = new android.support.v7.app.ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                drawerView.bringToFront();
                drawerView.requestLayout();
            }
        };
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

}
