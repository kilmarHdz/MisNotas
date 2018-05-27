package com.cabrera.misnotas;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.cabrera.misnotas.Database.DBHelper;
import com.cabrera.misnotas.Fragments.EditPerson;
import com.cabrera.misnotas.Fragments.InsertPerson;
import com.cabrera.misnotas.Fragments.SearchPerson;
import com.cabrera.misnotas.Fragments.ShowPerson;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout Drawver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBHelper.getInstance(this);
        Drawver = findViewById(R.id.drawer_layout);
        setNavigationViewListner();

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();;
        switch (item.getItemId()) {

            case R.id.nav_ingresar: {
                transaction.replace(R.id.content_frame, new InsertPerson());
                transaction.addToBackStack(null);
                transaction.commit();
                break;
            }
            case R.id.nav_mostrar: {
                transaction.replace(R.id.content_frame, ShowPerson.newInstance());
                transaction.addToBackStack(null);
                transaction.commit();
                break;
            }
            case R.id.nav_actualizar: {
                transaction.replace(R.id.content_frame, new EditPerson());
                transaction.addToBackStack(null);
                transaction.commit();
                break;
            }
            case R.id.nav_buscar: {
                transaction.replace(R.id.content_frame, new SearchPerson());
                transaction.addToBackStack(null);
                transaction.commit();
                break;
            }
        }
        //close navigation drawer
        Drawver.closeDrawer(GravityCompat.START);
        return true;
    }
    private void setNavigationViewListner() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }
}
