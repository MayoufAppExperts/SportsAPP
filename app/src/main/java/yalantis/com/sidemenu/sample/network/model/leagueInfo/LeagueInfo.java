package yalantis.com.sidemenu.sample.network.model.leagueInfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by TheAppExperts on 30/10/2017.
 */

public class LeagueInfo {
    @SerializedName("leagues")
    @Expose
    private List<League> leagues = null;

    public List<League> getLeagues() {
        return leagues;
    }

    public void setLeagues(List<League> leagues) {
        this.leagues = leagues;
    }

}
