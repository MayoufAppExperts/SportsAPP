package yalantis.com.sidemenu.sample.ui.prevScoresLeague;

import yalantis.com.sidemenu.sample.ui.base.MvpPresenter;

/**
 * Created by TheAppExperts on 30/10/2017.
 */

public interface IPrevLeagueResultsMvpPresenter <V extends IPrevLeagueResultsMvpView> extends MvpPresenter<V> {
    void onViewPrepared(String id);
}
