package com.badr.learningtrack.badrtaskii.home.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.badr.learningtrack.badrtaskii.R;
import com.badr.learningtrack.badrtaskii.model.pojos.Result;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;

/**
 * Created by ahmed-osama on 30/07/17.
 */

public class CustomAdapter  extends ArrayAdapter<Result>{
    private Context context;
    private Result User;
    @BindView(R.id.listNameID)
    TextView userName;

    @BindView(R.id.listStartTimeID)
    TextView userGender;

    @BindView(R.id.listEndTimeID)
    TextView userDOB;

    @BindView(R.id.listImageID)
    ImageView userimage;

    public CustomAdapter(Context context, List<Result> tasks) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, tasks);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View stepsList = convertView;
        if (stepsList == null) {
            stepsList = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        User = getItem(position);

        userName.setText(User.getName().getTitle() + " " + User.getName().getFirst() + " " + User.getName().getLast());
        userGender.setText(User.getGender());
        userDOB.setText(User.getDob());

        Glide.with(getContext()).load(User.getPicture().getMedium()).into(userimage);

        return stepsList;
    }

}
