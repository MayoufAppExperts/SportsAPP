package yalantis.com.sidemenu.sample.ui.myTeam;


import yalantis.com.sidemenu.sample.ui.base.MvpPresenter;

/**
 * Created by TheAppExperts on 19/10/2017.
 */

public interface IMyTeamMvpPresenter <V extends IMyTeamMvpView> extends MvpPresenter<V> {

    void onViewPrepared();
}
