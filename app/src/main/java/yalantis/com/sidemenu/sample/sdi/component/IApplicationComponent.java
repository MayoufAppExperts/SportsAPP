package yalantis.com.sidemenu.sample.sdi.component;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Component;
import yalantis.com.sidemenu.sample.DataManager;
import yalantis.com.sidemenu.sample.MyApp;
import yalantis.com.sidemenu.sample.sdi.module.ApplicationModule;
import yalantis.com.sidemenu.sample.sdi.scope.ApplicationContext;

/**
 * Created by TheAppExperts on 25/10/2017.
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface IApplicationComponent {

    void inject (MyApp myApp);

    Application getApplication();

    DataManager getDataManager();

}
