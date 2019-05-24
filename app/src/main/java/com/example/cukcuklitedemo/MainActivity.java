package com.example.cukcuklitedemo;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.example.cukcuklitedemo.reactproduct.insertproduct.InsertProductActivity;
import com.example.cukcuklitedemo.menu.MenuFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    /**
     * create by lntung date 5/23/2019
     *
     * @param savedInstanceState biến lưu trạng thái
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        MenuFragment fragment = MenuFragment.newInstance();
        addFragment(fragment);
    }

    private void addFragment(MenuFragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        @SuppressLint("CommitTransaction") FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.frm_content, fragment);
        transaction.commitAllowingStateLoss();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.action_insert) {
            openInsertProductActivity();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Mở màn hình thêm mới thực đơn
     * create by lntung date 5/23/2019
     */
    private void openInsertProductActivity() {
        Intent intent = new Intent(MainActivity.this, InsertProductActivity.class);
        startActivity(intent);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_sale) {

        } else if (id == R.id.nav_menu) {
          //  addFragment(MenuFragment.getInstance());
        } else if (id == R.id.nav_report) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
