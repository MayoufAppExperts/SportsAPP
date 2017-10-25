package yalantis.com.sidemenu.sample.ui.liveScores;

import yalantis.com.sidemenu.sample.network.model.livescores.LiveScores;
import yalantis.com.sidemenu.sample.ui.base.MvpView;

/**
 * Created by TheAppExperts on 23/10/2017.
 */

public interface ILiveScoresMvpView extends MvpView{

    void onLiveScoresFetchCompleted(LiveScores liveScores);

}
