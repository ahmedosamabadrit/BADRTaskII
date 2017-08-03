package com.badr.learningtrack.badrtaskii.home.module;

import android.content.Context;

import com.badr.learningtrack.badrtaskii.home.HomeInteractorIMPL;
import com.badr.learningtrack.badrtaskii.home.HomePresenterIMPL;
import com.badr.learningtrack.badrtaskii.home.dialogs.AlertDialogManager;
import com.badr.learningtrack.badrtaskii.home.interfaces.HomeInteractor;
import com.badr.learningtrack.badrtaskii.home.interfaces.HomePresenter;
import com.badr.learningtrack.badrtaskii.home.interfaces.HomeView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ahmed-osama on 31/07/17.
 */

@Module
public class HomeModule {

    private HomeView view;
    private Context context;
    public HomeModule(Context context ,HomeView view) {

        this.view = view;
        this.context = context;
    }

    @Provides
    public HomePresenter providePresenter(HomeInteractor interactor) {
        return new HomePresenterIMPL(view ,interactor);
    }

    @Provides
    public HomeInteractor provideHomeInteractor() {
        return new HomeInteractorIMPL();
    }


    @Provides
    public AlertDialogManager provideAlertDialogManager() {
        return new AlertDialogManager();
    }

}
