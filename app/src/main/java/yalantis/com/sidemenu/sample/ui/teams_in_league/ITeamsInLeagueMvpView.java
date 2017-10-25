package yalantis.com.sidemenu.sample.ui.teams_in_league;

import yalantis.com.sidemenu.sample.network.model.myteam.MyTeamModel;
import yalantis.com.sidemenu.sample.ui.base.MvpView;

/**
 * Created by TheAppExperts on 23/10/2017.
 */

public interface ITeamsInLeagueMvpView extends MvpView {

    void onFetchDataCompleted(MyTeamModel myTeamModel);
}
