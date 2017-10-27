package yalantis.com.sidemenu.sample;


import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import yalantis.com.sidemenu.sample.network.ApiHelper;
import yalantis.com.sidemenu.sample.network.AppApiHelper;
import yalantis.com.sidemenu.sample.network.model.FootballModel;
import yalantis.com.sidemenu.sample.network.model.livescores.LiveScores;
import yalantis.com.sidemenu.sample.network.model.myteam.MyTeamModel;
import yalantis.com.sidemenu.sample.network.model.previousModel.PreviousFixtures;
import yalantis.com.sidemenu.sample.network.model.upcomingEvents.UpcomingEvents;

/**
 * Created by TheAppExperts on 18/10/2017.
 */
@Singleton
public class AppDataManager implements DataManager {

    private ApiHelper apiHelper;


    @Inject
    public AppDataManager() {
        this.apiHelper = new AppApiHelper();
    }

    @Override
    public Observable<FootballModel> useCaseLeagueList() {
        return apiHelper.useCaseLeagueList();
    }

    @Override
    public Observable<MyTeamModel> useCaseMyTeam() {
        return apiHelper.useCaseMyTeam();
    }

    @Override
    public Observable<MyTeamModel> useCaseTeamsInLeague(String id) {
        return apiHelper.useCaseTeamsInLeague(id);
    }

    @Override
    public Observable<MyTeamModel> useCaseTeamInfo(String id) {
        return apiHelper.useCaseTeamInfo(id);
    }

    @Override
    public Observable<LiveScores> useCaseLiveScores() {
        return apiHelper.useCaseLiveScores();
    }

    @Override
    public Observable<PreviousFixtures> useCasePreviousFixtures(String id) {
        return apiHelper.useCasePreviousFixtures(id);
    }

    @Override
    public Observable<UpcomingEvents> useCaseUpcomingEvents(String id) {
        return apiHelper.useCaseUpcomingEvents(id);
    }
}
