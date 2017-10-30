package yalantis.com.sidemenu.sample.ui.leagueInfo;

import yalantis.com.sidemenu.sample.ui.base.MvpPresenter;

/**
 * Created by TheAppExperts on 30/10/2017.
 */

public interface ILeagueInfoMvpPresenter <V extends ILeagueInfoMvpView> extends MvpPresenter<V> {
    void onViewPrepared(String id);
}
