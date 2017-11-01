package yalantis.com.sidemenu.sample.ui.leagues;


import yalantis.com.sidemenu.sample.ui.base.MvpPresenter;

/**
 * Created by TheAppExperts on 18/10/2017.
 */

public interface ILeaguesMvpPresenter <V extends ILeaguesMvpView> extends MvpPresenter<V> {

    void onViewPrepared();
}
