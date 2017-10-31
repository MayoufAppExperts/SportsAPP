package yalantis.com.sidemenu.sample.ui.nextLeague;

import yalantis.com.sidemenu.sample.ui.base.MvpPresenter;

/**
 * Created by TheAppExperts on 31/10/2017.
 */

public interface INextLeagueFixMvpPresenter <V extends INextLeagueFixMvpView> extends MvpPresenter<V> {

    void onViewPrepared(String id);
}
