package yalantis.com.sidemenu.sample.sdi.component;

import android.support.v4.app.Fragment;

import dagger.Component;
import yalantis.com.sidemenu.sample.fragment.LeaguesFrag;
import yalantis.com.sidemenu.sample.fragment.LiveScoresFrag;
import yalantis.com.sidemenu.sample.fragment.TeamInfoFrag;
import yalantis.com.sidemenu.sample.network.model.livescores.LiveScores;
import yalantis.com.sidemenu.sample.sdi.module.ActivityModule;
import yalantis.com.sidemenu.sample.sdi.scope.PerActivity;

/**
 * Created by TheAppExperts on 24/10/2017.
 */
@PerActivity
@Component(dependencies = IApplicationComponent.class, modules = ActivityModule.class)
public interface IActivityComponent {

    void inject (LeaguesFrag fragment);
    void inject (LiveScoresFrag liveScoresFrag);
    void inject (TeamInfoFrag teamInfoFrag);
}
