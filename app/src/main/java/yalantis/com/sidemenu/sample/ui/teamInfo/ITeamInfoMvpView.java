package yalantis.com.sidemenu.sample.ui.teamInfo;

import yalantis.com.sidemenu.sample.network.model.MyTeamModel;
import yalantis.com.sidemenu.sample.ui.base.MvpView;

/**
 * Created by TheAppExperts on 23/10/2017.
 */

public interface ITeamInfoMvpView extends MvpView {

    void onFetchMyTeamCompleted(MyTeamModel myTeamModel);
}
