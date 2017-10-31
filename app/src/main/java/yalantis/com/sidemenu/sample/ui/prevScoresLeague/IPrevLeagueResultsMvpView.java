package yalantis.com.sidemenu.sample.ui.prevScoresLeague;

import yalantis.com.sidemenu.sample.network.model.leaguePreResults.LeaguesPrev;
import yalantis.com.sidemenu.sample.ui.base.MvpView;

/**
 * Created by TheAppExperts on 30/10/2017.
 */

public interface IPrevLeagueResultsMvpView extends MvpView{

    void onFetchPrevResultsCompleted(LeaguesPrev leaguesPrev);
}
