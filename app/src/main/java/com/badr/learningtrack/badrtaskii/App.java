package com.badr.learningtrack.badrtaskii;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.github.xizzhu.stetho.realm.StethoRealmInspectorModulesProvider;

import java.io.File;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by ahmed-osama on 03/08/17.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder().build();
        Realm.setDefaultConfiguration(config);

        Stetho.initialize(Stetho.newInitializerBuilder(this)
                .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                .enableWebKitInspector(
                        new StethoRealmInspectorModulesProvider.Builder(this).dirs(getFilesDir(),
                                new File(getFilesDir(), "custom")).build())
                .build());
    }
}