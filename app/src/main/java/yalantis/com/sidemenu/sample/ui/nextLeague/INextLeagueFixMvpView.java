package yalantis.com.sidemenu.sample.ui.nextLeague;

import yalantis.com.sidemenu.sample.network.model.leagueNextFix.LeaguesNext;
import yalantis.com.sidemenu.sample.network.model.leaguePreResults.LeaguesPrev;
import yalantis.com.sidemenu.sample.ui.base.MvpPresenter;
import yalantis.com.sidemenu.sample.ui.base.MvpView;

/**
 * Created by TheAppExperts on 31/10/2017.
 */

public interface INextLeagueFixMvpView extends MvpView {

    void onFetchNextLeagueCompleted(LeaguesNext leaguesNext);
}
