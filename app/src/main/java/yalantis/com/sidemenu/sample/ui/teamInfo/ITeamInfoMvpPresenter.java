package yalantis.com.sidemenu.sample.ui.teamInfo;

import yalantis.com.sidemenu.sample.ui.base.MvpPresenter;
import yalantis.com.sidemenu.sample.ui.teams_in_league.ITeamsInLeagueMvpView;

/**
 * Created by TheAppExperts on 23/10/2017.
 */

public interface ITeamInfoMvpPresenter <V extends ITeamInfoMvpView> extends MvpPresenter<V> {

    void onViewPrepared(String id);
}
