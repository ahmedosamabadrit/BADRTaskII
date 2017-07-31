package com.badr.learningtrack.badrtaskii.model.networkmanager.module;

import com.badr.learningtrack.badrtaskii.model.networkmanager.NetWorkManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ahmed-osama on 31/07/17.
 */

@Module
public class NetworkModule {

    @Provides
    @Singleton
    public NetWorkManager provideNetworkManager(){
        return new NetWorkManager();
    }
}
