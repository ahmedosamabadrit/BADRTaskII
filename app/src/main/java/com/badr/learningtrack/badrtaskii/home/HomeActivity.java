package com.badr.learningtrack.badrtaskii.home;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.badr.learningtrack.badrtaskii.R;
import com.badr.learningtrack.badrtaskii.home.Components.DaggerHomeComponent;
import com.badr.learningtrack.badrtaskii.home.dialogs.AlertDialogManager;
import com.badr.learningtrack.badrtaskii.home.fragments.ListFragment;
import com.badr.learningtrack.badrtaskii.home.fragments.MapFragment;
import com.badr.learningtrack.badrtaskii.home.interfaces.HomePresenter;
import com.badr.learningtrack.badrtaskii.home.interfaces.HomeView;
import com.badr.learningtrack.badrtaskii.home.module.HomeModule;
import com.badr.learningtrack.badrtaskii.model.pojos.Result;

import java.util.ArrayList;

import javax.inject.Inject;

public class HomeActivity extends AppCompatActivity implements HomeView {

    @Inject
    HomePresenter presenter;

    // Connection detector class
    @Inject
    ConnectionDetector cd;

    @Inject
    AlertDialogManager custom_alertDialog_interface;


    // flag for network status
    private boolean isInternetPresent = false;

    private ProgressDialog pDialog;

    private ArrayList<Result> users;

    private ListFragment first_fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        /// There two way to pass the view throw and a conestractour
        DaggerHomeComponent.builder()
                .homeModule(new HomeModule(getApplicationContext(),this))
                .build()
                .inject(this);

        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);

        // Check if Internet present
        isInternetPresent = cd.isConnectingToInternet();

        if (!isInternetPresent) {
            custom_alertDialog_interface.showAlertDialog(this, getString(R.string.network_connection_error_title), getString(R.string.network_connection_error_message), false);
        }
        /// Showing the progress Dialog.
        showProgressDialog();

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
        first_fragment = ListFragment.newInstance();
        transaction.replace(R.id.frame_layout, first_fragment);
        transaction.commit();
    }

    /// This method will be call
    @Override
    public void showUsersData(ArrayList<Result> usersList) {
        users = usersList;
        first_fragment.setUsers(users);
    }

    @Override
    public void showProgressDialog() {
        pDialog.show();
    }

    @Override
    public void HideProgressDialog() {
        pDialog.hide();
    }
}
