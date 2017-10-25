package yalantis.com.sidemenu.sample.ui.myTeam;


import yalantis.com.sidemenu.sample.network.model.myteam.MyTeamModel;
import yalantis.com.sidemenu.sample.ui.base.MvpView;

/**
 * Created by TheAppExperts on 19/10/2017.
 */

public interface IMyTeamMvpView extends MvpView {

    void onFetchMyTeamCompleted(MyTeamModel myTeamModel);
}
