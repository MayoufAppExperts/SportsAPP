package yalantis.com.sidemenu.sample;


import io.reactivex.Observable;
import yalantis.com.sidemenu.sample.network.ApiHelper;
import yalantis.com.sidemenu.sample.network.AppApiHelper;
import yalantis.com.sidemenu.sample.network.model.FootballModel;
import yalantis.com.sidemenu.sample.network.model.MyTeamModel;

/**
 * Created by TheAppExperts on 18/10/2017.
 */

public class AppDataManager implements DataManager {

    private ApiHelper apiHelper;

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
}
