package yalantis.com.sidemenu.sample.network;


import io.reactivex.Observable;
import yalantis.com.sidemenu.sample.network.model.FootballModel;
import yalantis.com.sidemenu.sample.network.model.leagueInfo.LeagueInfo;
import yalantis.com.sidemenu.sample.network.model.leagueNextFix.LeaguesNext;
import yalantis.com.sidemenu.sample.network.model.leaguePreResults.LeaguesPrev;
import yalantis.com.sidemenu.sample.network.model.livescores.LiveScores;
import yalantis.com.sidemenu.sample.network.model.myteam.MyTeamModel;
import yalantis.com.sidemenu.sample.network.model.previousModel.PreviousFixtures;
import yalantis.com.sidemenu.sample.network.model.upcomingEvents.UpcomingEvents;

/**
 * Created by TheAppExperts on 18/10/2017.
 */

public interface ApiHelper {
    Observable<FootballModel> useCaseLeagueList();
    Observable<MyTeamModel> useCaseMyTeam();
    Observable<MyTeamModel> useCaseTeamsInLeague(String id);
    Observable<MyTeamModel> useCaseTeamInfo(String id);
    Observable<LiveScores> useCaseLiveScores();
    Observable<PreviousFixtures> useCasePreviousFixtures(String id);
    Observable<UpcomingEvents> useCaseUpcomingEvents(String id);
    Observable<LeagueInfo> useCaseLeagueInfo(String id);
    Observable<LeaguesPrev> useCasePreviousLeagueResults(String id);
    Observable<LeaguesNext> useCaseNextLeagueFixtures(String id);
    Observable<LeaguesPrev> useCaseDayEvents(String d);
}
