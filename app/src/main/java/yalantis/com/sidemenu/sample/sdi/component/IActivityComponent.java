package yalantis.com.sidemenu.sample.sdi.component;

import dagger.Component;
import yalantis.com.sidemenu.sample.fragment.DayEventFrag;
import yalantis.com.sidemenu.sample.fragment.LeagueInfoFrag;
import yalantis.com.sidemenu.sample.fragment.LeaguePreResultsFrag;
import yalantis.com.sidemenu.sample.fragment.LeaguesFrag;
import yalantis.com.sidemenu.sample.fragment.LiveScoresFrag;
import yalantis.com.sidemenu.sample.fragment.NextLeagueFixFrag;
import yalantis.com.sidemenu.sample.fragment.PreviousResultFrag;
import yalantis.com.sidemenu.sample.fragment.TeamInfoFrag;
import yalantis.com.sidemenu.sample.fragment.TeamsInLeaguesFrag;
import yalantis.com.sidemenu.sample.fragment.UpcomingEventsFrag;
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
    void inject (PreviousResultFrag previousResultFrag);
    void inject (UpcomingEventsFrag upcomingEventsFrag);
    void inject (LeagueInfoFrag leagueInfoFrag);
    void inject (LeaguePreResultsFrag preResultsFrag);
    void inject (NextLeagueFixFrag nextLeagueFixFrag);
    void inject (DayEventFrag dayEventFrag);
    void inject (TeamsInLeaguesFrag teamsInLeaguesFrag);
}
