package com.badr.learningtrack.badrtaskii.home.Components;

import com.badr.learningtrack.badrtaskii.home.HomeActivity;
import com.badr.learningtrack.badrtaskii.home.module.HomeModule;
import com.badr.learningtrack.badrtaskii.model.networkmanager.module.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by ahmed-osama on 31/07/17.
 */

@Component(modules = {
        HomeModule.class,
        NetworkModule.class
})

@Singleton
public interface HomeComponent {
    public void inject(HomeActivity homeActivity);
}
