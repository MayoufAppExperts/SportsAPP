package yalantis.com.sidemenu.sample.ui.leagues;


import yalantis.com.sidemenu.sample.ui.base.MvpPresenter;
import yalantis.com.sidemenu.sample.ui.base.MvpView;

/**
 * Created by TheAppExperts on 18/10/2017.
 */

public interface ILeaguesMvpPresenter <V extends ILeaguesMvpView & MvpView> extends MvpPresenter<V> {

    void onViewPrepared();
}
