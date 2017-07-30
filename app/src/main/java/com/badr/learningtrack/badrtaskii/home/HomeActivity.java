package com.badr.learningtrack.badrtaskii.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.badr.learningtrack.badrtaskii.R;
import com.badr.learningtrack.badrtaskii.home.dialogs.AlertDialogManager;
import com.badr.learningtrack.badrtaskii.home.fragments.ListFragment;
import com.badr.learningtrack.badrtaskii.home.fragments.MapFragment;
import com.badr.learningtrack.badrtaskii.home.interfaces.HomePresenter;
import com.badr.learningtrack.badrtaskii.home.interfaces.HomeView;
import com.badr.learningtrack.badrtaskii.home.presenter.HomePresenterIMPL;
import com.badr.learningtrack.badrtaskii.model.pojos.Result;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements HomeView {

    private HomePresenter presenter;

    // flag for network status
    boolean isInternetPresent = false;

    // Connection detector class\
    private ConnectionDetector cd;

    private AlertDialogManager custom_alertDialog_interface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        /// Creating object form presenter and paa the View Interface for it .
        presenter = new HomePresenterIMPL(this);

        // Creating object from connection and pass the context as arguments.
        cd = new ConnectionDetector(getApplicationContext());

        // Check if Internet present
        isInternetPresent = cd.isConnectingToInternet();

        custom_alertDialog_interface = new AlertDialogManager();

        if(!isInternetPresent)
        {
            custom_alertDialog_interface.showAlertDialog(this, getString(R.string.network_connection_error_title), getString(R.string.network_connection_error_message), false);
        }
        // pas the value of the connection to the presenter.
        presenter.readyToGO(isInternetPresent);

        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener
                (new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Fragment selectedFragment = null;
                        switch (item.getItemId()) {
                            case R.id.action_item1:
                                selectedFragment = ListFragment.newInstance();
                                break;
                            case R.id.action_item2:
                                selectedFragment = MapFragment.newInstance();
                                break;

                        }
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frame_layout, selectedFragment);
                        transaction.commit();
                        return true;
                    }
                });

        //Manually displaying the first fragment - one time only
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, ListFragment.newInstance());
        transaction.commit();
    }

    @Override
    public void showUsersData(ArrayList<Result> usersList) {

    }

    @Override
    public ArrayList<Result> getListOfUsers() {
        return null;
    }
}
