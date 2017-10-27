package yalantis.com.sidemenu.sample.ui.upcomingEvents;

import yalantis.com.sidemenu.sample.network.model.upcomingEvents.UpcomingEvents;
import yalantis.com.sidemenu.sample.ui.base.MvpView;

/**
 * Created by TheAppExperts on 26/10/2017.
 */

public interface IUpcomingEventsMvpView extends MvpView{

    void onFetchUpcomingEvents(UpcomingEvents upcomingEvents);
}
