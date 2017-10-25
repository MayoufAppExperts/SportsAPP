package yalantis.com.sidemenu.sample.ui.liveScores;

import yalantis.com.sidemenu.sample.ui.base.MvpPresenter;
import yalantis.com.sidemenu.sample.ui.base.MvpView;
import yalantis.com.sidemenu.sample.ui.teamInfo.ITeamInfoMvpView;

/**
 * Created by TheAppExperts on 23/10/2017.
 */

public interface ILiveScoresMvpPresenter <V extends ILiveScoresMvpView> extends MvpPresenter<V> {

    void onViewPrepared();
}
