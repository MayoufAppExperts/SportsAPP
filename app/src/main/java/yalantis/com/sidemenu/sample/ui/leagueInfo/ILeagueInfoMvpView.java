package yalantis.com.sidemenu.sample.ui.leagueInfo;

import yalantis.com.sidemenu.sample.network.model.leagueInfo.LeagueInfo;
import yalantis.com.sidemenu.sample.ui.base.MvpView;

/**
 * Created by TheAppExperts on 30/10/2017.
 */

public interface ILeagueInfoMvpView extends MvpView {

    void onFetchLeagueInfoCompleted(LeagueInfo leagueInfo);
}
