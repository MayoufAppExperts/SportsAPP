package yalantis.com.sidemenu.sample;

import android.app.Application;
import android.content.Context;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import yalantis.com.sidemenu.sample.sdi.component.DaggerIApplicationComponent;
import yalantis.com.sidemenu.sample.sdi.component.IApplicationComponent;
import yalantis.com.sidemenu.sample.sdi.module.ApplicationModule;

/**
 * Created by Mohammed on 01/10/2017.
 */

public class MyApp extends Application {


    public static Application sApplication;
    IApplicationComponent iApplicationComponent;

    public IApplicationComponent getiApplicationComponent() {
        return iApplicationComponent;
    }

    public static Application getApplication() {
        return sApplication;
    }

    public static Context getContext() {
        return getApplication().getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sApplication = this;


        iApplicationComponent = DaggerIApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();

        getiApplicationComponent().inject(this);

        realmCreate();


    }

    /**
     * TODO
     * Remove names from club logo - done
     * USE CALENDAR FOR DATE - done
     * DISPLAY THE COMPETITION - DONE
     * PROGRESS DIALOG
     * CARDVIEW TRANSPARENT - done
     * faction button for viewing events by day, by default today date loads - done
     * replace icons accordingly
     * add time for fixtures - done
     * click on previous fixtures and show youtube API - done
     * LOCALE LANG - DONE
     *
     */



    private void realmCreate() {
        Realm.init(getApplicationContext());
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .name(Realm.DEFAULT_REALM_NAME)
                .schemaVersion(3)
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);
    }
}