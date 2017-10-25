package yalantis.com.sidemenu.sample.network;


import io.reactivex.Observable;
import yalantis.com.sidemenu.sample.network.model.FootballModel;
import yalantis.com.sidemenu.sample.network.model.livescores.LiveScores;
import yalantis.com.sidemenu.sample.network.model.myteam.MyTeamModel;

/**
 * Created by TheAppExperts on 18/10/2017.
 */

public interface ApiHelper {
    Observable<FootballModel> useCaseLeagueList();
    Observable<MyTeamModel> useCaseMyTeam();
    Observable<MyTeamModel> useCaseTeamsInLeague(String id);
    Observable<MyTeamModel> useCaseTeamInfo(String id);
    Observable<LiveScores> useCaseLiveScores();
}
