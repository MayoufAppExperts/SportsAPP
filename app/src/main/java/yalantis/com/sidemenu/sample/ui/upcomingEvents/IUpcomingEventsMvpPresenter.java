package yalantis.com.sidemenu.sample.ui.upcomingEvents;

import yalantis.com.sidemenu.sample.ui.base.MvpPresenter;

/**
 * Created by TheAppExperts on 26/10/2017.
 */

public interface IUpcomingEventsMvpPresenter <V extends IUpcomingEventsMvpView> extends MvpPresenter<V> {
    void onViewPrepared(String id);
}
