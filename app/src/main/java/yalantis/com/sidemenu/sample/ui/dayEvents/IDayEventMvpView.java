package yalantis.com.sidemenu.sample.ui.dayEvents;

import yalantis.com.sidemenu.sample.network.model.leaguePreResults.LeaguesPrev;
import yalantis.com.sidemenu.sample.ui.base.MvpView;

/**
 * Created by TheAppExperts on 31/10/2017.
 */

public interface IDayEventMvpView extends MvpView {

    void onFetchDayEventCompleted(LeaguesPrev leaguesPrev);
}
