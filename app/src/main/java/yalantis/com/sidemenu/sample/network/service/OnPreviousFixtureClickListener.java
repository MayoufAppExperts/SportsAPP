package yalantis.com.sidemenu.sample.network.service;

import yalantis.com.sidemenu.sample.network.model.myteam.Team;

/**
 * Created by TheAppExperts on 25/10/2017.
 */

public interface OnPreviousFixtureClickListener {
    void onItemClick(Team team);
    void onItemUpClick(Team team);
}
