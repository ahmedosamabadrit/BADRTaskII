package com.badr.learningtrack.badrtaskii.home.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.badr.learningtrack.badrtaskii.R;
import com.badr.learningtrack.badrtaskii.home.HomeActivity;
import com.badr.learningtrack.badrtaskii.home.adapter.CustomAdapter;
import com.badr.learningtrack.badrtaskii.model.pojos.Result;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListFragment extends Fragment {

    private View view;

    /// Array list will be in the listview.
    private ArrayList<Result> users;

    // CustomAdapter For the List.
    private CustomAdapter customAdapterobj;

    // List view will show up in the Fragmetn.
    @BindView(R.id.my_listview)
    ListView listview;

    // Reference from MainActivity to call the Method GetGasStatioList.
    private HomeActivity activity;


    public static ListFragment newInstance() {
        return new ListFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ButterKnife.bind(this, view);

        // Inflate the layout for this fragment
        //This layout contains your list view
        view = inflater.inflate(R.layout.fragment_list, container, false);

        //now you must initialize your list view

        /// Creating an object;
        activity = (HomeActivity) getActivity();

        /// Having the Array list  from the Delegate.
//        users = activity.getListOfUsers();

        users  = new ArrayList<>();
        Result ff =  new Result();
        ff.setCell("123412341");
        ff.setDob("asdfasdfasdfasdfasdfa");
        ff.setEmail("Asfadygfvibkuljhfvsgriun");
        users.add(ff);
        /// Create an object from the CustomAdapter i made and pass the Context and the list of the Gas Station Array. to it
        customAdapterobj = new CustomAdapter(getActivity(), users);

        // Setting the Adapter to the list
        listview.setAdapter(customAdapterobj);

        // Inflate the layout for this fragment
        return view;
    }
}
