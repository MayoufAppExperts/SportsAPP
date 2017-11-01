package yalantis.com.sidemenu.sample.ui.dayEvents;

import yalantis.com.sidemenu.sample.ui.base.MvpPresenter;

/**
 * Created by TheAppExperts on 31/10/2017.
 */

public interface IDayEventMvpPresenter <V extends IDayEventMvpView> extends MvpPresenter<V> {

    void onViewPrepared(String d);
}
