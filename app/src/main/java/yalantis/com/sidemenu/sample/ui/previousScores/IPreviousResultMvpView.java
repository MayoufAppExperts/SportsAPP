package yalantis.com.sidemenu.sample.ui.previousScores;

import yalantis.com.sidemenu.sample.network.model.previousModel.PreviousFixtures;
import yalantis.com.sidemenu.sample.ui.base.MvpView;

/**
 * Created by TheAppExperts on 25/10/2017.
 */

public interface IPreviousResultMvpView extends MvpView{

    void onFetchPreviousResult(PreviousFixtures previousFixtures);
}
