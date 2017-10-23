package yalantis.com.sidemenu.sample.ui.leagues;


import yalantis.com.sidemenu.sample.network.model.FootballModel;
import yalantis.com.sidemenu.sample.ui.base.MvpView;

/**
 * Created by TheAppExperts on 18/10/2017.
 */

public interface ILeaguesMvpView extends MvpView {

    void onFetchLeagueCompleted(FootballModel footballModel);


}
