package yalantis.com.sidemenu.sample.network.service;



import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import yalantis.com.sidemenu.sample.network.model.API_Constants;
import yalantis.com.sidemenu.sample.network.model.FootballModel;
import yalantis.com.sidemenu.sample.network.model.MyTeamModel;

/**
 * Created by Mohammed on 01/10/2017.
 */

public interface ReqInterface {

    @GET (API_Constants.LEAGUE_URL)
    Observable<FootballModel> getTeams();

    @GET (API_Constants.MY_TEAM)
    Observable<MyTeamModel> getMyTeam();

    @GET (API_Constants.TEAMS_IN_LEAGUE)
    Observable<MyTeamModel> getTeamsInLeague(@Query("id") String id);

    @GET (API_Constants.TEAM_INFO)
    Observable<MyTeamModel> getTeamInfo(@Query("id") String id);

}
