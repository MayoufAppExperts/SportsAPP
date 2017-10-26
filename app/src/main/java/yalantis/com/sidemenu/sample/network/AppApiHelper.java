package yalantis.com.sidemenu.sample.network;


import android.util.Log;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import yalantis.com.sidemenu.sample.network.model.FootballModel;
import yalantis.com.sidemenu.sample.network.model.livescores.LiveScores;
import yalantis.com.sidemenu.sample.network.model.myteam.MyTeamModel;
import yalantis.com.sidemenu.sample.network.model.previousModel.PreviousFixtures;
import yalantis.com.sidemenu.sample.network.service.ConnectionService;
import yalantis.com.sidemenu.sample.network.service.ReqInterface;

/**
 * Created by TheAppExperts on 18/10/2017.
 */
@Singleton
public class AppApiHelper implements ApiHelper {

    private ReqInterface reqInterface;

    @Inject
    public AppApiHelper() {
        this.reqInterface = ConnectionService.getConnectionService();
    }

    @Override
    public Observable<FootballModel> useCaseLeagueList() {
        return reqInterface.getTeams();
    }

    @Override
    public Observable<MyTeamModel> useCaseMyTeam() {
        return reqInterface.getMyTeam();
    }

    @Override
    public Observable<MyTeamModel> useCaseTeamsInLeague(String id) {
        return reqInterface.getTeamsInLeague(id);
    }

    @Override
    public Observable<MyTeamModel> useCaseTeamInfo(String id) {
        return reqInterface.getTeamInfo(id);
    }

    @Override
    public Observable<LiveScores> useCaseLiveScores() {
        return reqInterface.getLiveScores();
    }

    @Override
    public Observable<PreviousFixtures> useCasePreviousFixtures(String id) {
        return reqInterface.getPreviousResults(id);
    }


}
