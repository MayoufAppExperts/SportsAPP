package yalantis.com.sidemenu.sample.network.model.livescores;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LiveScores {

    @SerializedName("teams")
    @Expose
    private Teams teams;

    public Teams getTeams() {
        return teams;
    }

    public void setTeams(Teams teams) {
        this.teams = teams;
    }

}