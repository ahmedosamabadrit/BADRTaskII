package com.badr.learningtrack.badrtaskii.home.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.badr.learningtrack.badrtaskii.R;
import com.badr.learningtrack.badrtaskii.home.adapter.CustomAdapter;
import com.badr.learningtrack.badrtaskii.model.pojos.Result;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListFragment extends Fragment {

    private View view;

    /// Array list will be in the map.
    private ArrayList<Result> userList;

    // CustomAdapter For the List.
    private CustomAdapter customAdapterobj;

    @BindView(R.id.my_listview)
    // List view will show up in the Fragmetn.
    ListView listview;

    public static ListFragment newInstance() {
        ListFragment fragment = new ListFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        userList = new ArrayList<>();
        /// Create an object from the CustomAdapter i made and pass the Context and the list of the Gas Station Array. to it
        customAdapterobj = new CustomAdapter(getActivity(), userList);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //This layout contains your list view
        view = inflater.inflate(R.layout.fragment_list, container, false);

        ButterKnife.bind(this,view);

        // Setting the Adapter to the list
        listview.setAdapter(customAdapterobj);

        // Inflate the layout for this fragment
        return view;
    }
    public void setUsers(ArrayList<Result> users)
    {
        Log.i("Hello"," "+users.size());
        userList.clear();
        userList.addAll(users);
        customAdapterobj.notifyDataSetChanged();
    }
}
