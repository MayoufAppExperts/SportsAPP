package yalantis.com.sidemenu.sample.ui.teams_in_league;

import yalantis.com.sidemenu.sample.ui.base.MvpPresenter;

/**
 * Created by TheAppExperts on 23/10/2017.
 */

public interface ITeamsInLeagueMvpPresenter <V extends ITeamsInLeagueMvpView> extends MvpPresenter<V> {

    void onViewPrepared(String id);
}
