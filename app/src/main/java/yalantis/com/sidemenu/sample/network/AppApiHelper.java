package yalantis.com.sidemenu.sample.network;


import io.reactivex.Observable;
import yalantis.com.sidemenu.sample.network.model.FootballModel;
import yalantis.com.sidemenu.sample.network.model.MyTeamModel;
import yalantis.com.sidemenu.sample.network.service.ConnectionService;
import yalantis.com.sidemenu.sample.network.service.ReqInterface;

/**
 * Created by TheAppExperts on 18/10/2017.
 */

public class AppApiHelper implements ApiHelper {

    private ReqInterface reqInterface;

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
}
