package yalantis.com.sidemenu.sample.network.service;



import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import yalantis.com.sidemenu.sample.network.model.API_Constants;
import yalantis.com.sidemenu.sample.network.model.FootballModel;
import yalantis.com.sidemenu.sample.network.model.leagueInfo.LeagueInfo;
import yalantis.com.sidemenu.sample.network.model.leagueNextFix.LeaguesNext;
import yalantis.com.sidemenu.sample.network.model.leaguePreResults.LeaguesPrev;
import yalantis.com.sidemenu.sample.network.model.livescores.LiveScores;
import yalantis.com.sidemenu.sample.network.model.myteam.MyTeamModel;
import yalantis.com.sidemenu.sample.network.model.previousModel.PreviousFixtures;
import yalantis.com.sidemenu.sample.network.model.upcomingEvents.UpcomingEvents;

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

    @GET (API_Constants.LIVE_SCORE)
    Observable<LiveScores> getLiveScores();

    @GET (API_Constants.PAST_EVENTS)
    Observable<PreviousFixtures> getPreviousResults(@Query("id") String id);

    @GET (API_Constants.NEXT_EVENTS)
    Observable<UpcomingEvents> getNextEvents(@Query("id") String id);

    @GET (API_Constants.LEAGUE_INFO)
    Observable<LeagueInfo> getLeagueInfo(@Query("id") String id);

    @GET (API_Constants.PREV_LEAGUE_RESULTS)
    Observable<LeaguesPrev> getPreviousLeagueResults(@Query("id") String id);

    @GET (API_Constants.NEXT_LEAGUE_FIX)
    Observable<LeaguesNext> getNextLeagueFixtures(@Query("id") String id, @Query("r") String r);

    @GET (API_Constants.DAY_EVENT)
    Observable<LeaguesPrev> getEventByDay(@Query("d") String date, @Query("s") String s);

}
