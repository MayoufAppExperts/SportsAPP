package yalantis.com.sidemenu.sample.ui.previousScores;

import yalantis.com.sidemenu.sample.ui.base.MvpPresenter;

/**
 * Created by TheAppExperts on 25/10/2017.
 */

public interface IPreviousResultMvpPresenter <V extends IPreviousResultMvpView> extends MvpPresenter<V>{
    void onViewPrepared(String id);
}
