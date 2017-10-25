package yalantis.com.sidemenu.sample.sdi.module;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import yalantis.com.sidemenu.sample.AppDataManager;
import yalantis.com.sidemenu.sample.DataManager;
import yalantis.com.sidemenu.sample.network.ApiHelper;
import yalantis.com.sidemenu.sample.network.AppApiHelper;
import yalantis.com.sidemenu.sample.sdi.scope.ApplicationContext;

/**
 * Created by TheAppExperts on 25/10/2017.
 */

@Module
public class ApplicationModule {

    Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    @ApplicationContext
    Context context (){
        return application;
    }

    @Provides
    Application getApplication(){
        return application;
    }

    @Provides
    @Singleton
    DataManager provideAppDataManager(AppDataManager appDataManager){
        return appDataManager;
    }

    @Provides
    @Singleton
    ApiHelper provideAppApiHelper(AppApiHelper appApiHelper){
        return appApiHelper;

    }
}
