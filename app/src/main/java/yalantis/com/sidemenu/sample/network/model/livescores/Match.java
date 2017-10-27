package yalantis.com.sidemenu.sample.network.model.livescores;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import yalantis.com.sidemenu.sample.network.model.livescores.AwayGoalDetails;
import yalantis.com.sidemenu.sample.network.model.livescores.AwayLineupDefense;
import yalantis.com.sidemenu.sample.network.model.livescores.AwayLineupForward;
import yalantis.com.sidemenu.sample.network.model.livescores.AwayLineupGoalkeeper;
import yalantis.com.sidemenu.sample.network.model.livescores.AwayLineupMidfield;
import yalantis.com.sidemenu.sample.network.model.livescores.AwayLineupSubstitutes;
import yalantis.com.sidemenu.sample.network.model.livescores.AwaySubDetails;
import yalantis.com.sidemenu.sample.network.model.livescores.AwayTeamFormation;
import yalantis.com.sidemenu.sample.network.model.livescores.AwayTeamRedCardDetails;
import yalantis.com.sidemenu.sample.network.model.livescores.AwayTeamYellowCardDetails;
import yalantis.com.sidemenu.sample.network.model.livescores.HomeGoalDetails;
import yalantis.com.sidemenu.sample.network.model.livescores.HomeLineupDefense;
import yalantis.com.sidemenu.sample.network.model.livescores.HomeLineupForward;
import yalantis.com.sidemenu.sample.network.model.livescores.HomeLineupGoalkeeper;
import yalantis.com.sidemenu.sample.network.model.livescores.HomeLineupMidfield;
import yalantis.com.sidemenu.sample.network.model.livescores.HomeLineupSubstitutes;
import yalantis.com.sidemenu.sample.network.model.livescores.HomeSubDetails;
import yalantis.com.sidemenu.sample.network.model.livescores.HomeTeamFormation;
import yalantis.com.sidemenu.sample.network.model.livescores.HomeTeamRedCardDetails;
import yalantis.com.sidemenu.sample.network.model.livescores.HomeTeamYellowCardDetails;
import yalantis.com.sidemenu.sample.network.model.livescores.Spectators;

public class Match {

    @SerializedName("Date")
    @Expose
    private String date;
    @SerializedName("League")
    @Expose
    private String league;
    @SerializedName("Round")
    @Expose
    private String round;
    @SerializedName("Spectators")
    @Expose
    private Spectators spectators;
    @SerializedName("HomeTeam")
    @Expose
    private String homeTeam;
    @SerializedName("HomeTeam_Id")
    @Expose
    private HomeTeamId homeTeamId;
    @SerializedName("AwayTeam")
    @Expose
    private String awayTeam;
    @SerializedName("AwayTeam_Id")
    @Expose
    private AwayTeamId awayTeamId;
    @SerializedName("Time")
    @Expose
    private String time;
    @SerializedName("HomeGoals")
    @Expose
    private String homeGoals;
    @SerializedName("AwayGoals")
    @Expose
    private String awayGoals;
    @SerializedName("HomeGoalDetails")
    @Expose
    private HomeGoalDetails homeGoalDetails;
    @SerializedName("AwayGoalDetails")
    @Expose
    private AwayGoalDetails awayGoalDetails;
    @SerializedName("HomeLineupGoalkeeper")
    @Expose
    private HomeLineupGoalkeeper homeLineupGoalkeeper;
    @SerializedName("AwayLineupGoalkeeper")
    @Expose
    private AwayLineupGoalkeeper awayLineupGoalkeeper;
    @SerializedName("HomeLineupDefense")
    @Expose
    private HomeLineupDefense homeLineupDefense;
    @SerializedName("AwayLineupDefense")
    @Expose
    private AwayLineupDefense awayLineupDefense;
    @SerializedName("HomeLineupMidfield")
    @Expose
    private HomeLineupMidfield homeLineupMidfield;
    @SerializedName("AwayLineupMidfield")
    @Expose
    private AwayLineupMidfield awayLineupMidfield;
    @SerializedName("HomeLineupForward")
    @Expose
    private HomeLineupForward homeLineupForward;
    @SerializedName("AwayLineupForward")
    @Expose
    private AwayLineupForward awayLineupForward;
    @SerializedName("HomeLineupSubstitutes")
    @Expose
    private HomeLineupSubstitutes homeLineupSubstitutes;
    @SerializedName("AwayLineupSubstitutes")
    @Expose
    private AwayLineupSubstitutes awayLineupSubstitutes;
    @SerializedName("HomeLineupCoach")
    @Expose
    private HomeLineupCoach homeLineupCoach;
    @SerializedName("AwayLineupCoach")
    @Expose
    private AwayLineupCoach awayLineupCoach;
    @SerializedName("HomeSubDetails")
    @Expose
    private HomeSubDetails homeSubDetails;
    @SerializedName("AwaySubDetails")
    @Expose
    private AwaySubDetails awaySubDetails;
    @SerializedName("HomeTeamFormation")
    @Expose
    private String homeTeamFormation;
    @SerializedName("AwayTeamFormation")
    @Expose
    private String awayTeamFormation;
    @SerializedName("Location")
    @Expose
    private String location;
    @SerializedName("Stadium")
    @Expose
    private String stadium;
    @SerializedName("HomeTeamYellowCardDetails")
    @Expose
    private String homeTeamYellowCardDetails;
    @SerializedName("AwayTeamYellowCardDetails")
    @Expose
    private String awayTeamYellowCardDetails;
    @SerializedName("HomeTeamRedCardDetails")
    @Expose
    private String homeTeamRedCardDetails;
    @SerializedName("AwayTeamRedCardDetails")
    @Expose
    private String awayTeamRedCardDetails;
    @SerializedName("Referee")
    @Expose
    private String referee;
    @SerializedName("HasBeenRescheduled")
    @Expose
    private String hasBeenRescheduled;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
    }

    public String getRound() {
        return round;
    }

    public void setRound(String round) {
        this.round = round;
    }

    public Spectators getSpectators() {
        if (spectators!=null){
        return spectators;
        }
        else {
            return null;
        }
    }

    public void setSpectators(Spectators spectators) {
        this.spectators = spectators;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public HomeTeamId getHomeTeamId() {
        if (homeTeamId != null) {
            return homeTeamId;
        }
        else {
            return null;
        }
    }

    public void setHomeTeamId(HomeTeamId homeTeamId) {
        this.homeTeamId = homeTeamId;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public AwayTeamId getAwayTeamId() {
        if (awayTeamId != null) {
            return awayTeamId;
        }
        else {
            return null;
        }
    }

    public void setAwayTeamId(AwayTeamId awayTeamId) {
        this.awayTeamId = awayTeamId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getHomeGoals() {
        return homeGoals;
    }

    public void setHomeGoals(String homeGoals) {
        this.homeGoals = homeGoals;
    }

    public String getAwayGoals() {
        return awayGoals;
    }

    public void setAwayGoals(String awayGoals) {
        this.awayGoals = awayGoals;
    }

    public HomeGoalDetails getHomeGoalDetails() {
        if (homeGoalDetails != null) {
            return homeGoalDetails;
        }
        else {
            return null;
        }
    }

    public void setHomeGoalDetails(HomeGoalDetails homeGoalDetails) {
        this.homeGoalDetails = homeGoalDetails;
    }

    public AwayGoalDetails getAwayGoalDetails() {
        if (awayGoalDetails != null) {
            return awayGoalDetails;
        }
        else {
            return null;
        }
    }

    public void setAwayGoalDetails(AwayGoalDetails awayGoalDetails) {
        this.awayGoalDetails = awayGoalDetails;
    }

    public HomeLineupGoalkeeper getHomeLineupGoalkeeper() {
        if (homeLineupGoalkeeper != null) {
            return homeLineupGoalkeeper;
        }
        else {
            return null;
        }
    }

    public void setHomeLineupGoalkeeper(HomeLineupGoalkeeper homeLineupGoalkeeper) {
        this.homeLineupGoalkeeper = homeLineupGoalkeeper;
    }

    public AwayLineupGoalkeeper getAwayLineupGoalkeeper() {
        if (awayLineupGoalkeeper != null) {
            return awayLineupGoalkeeper;
        }
        else {
            return null;
        }
    }

    public void setAwayLineupGoalkeeper(AwayLineupGoalkeeper awayLineupGoalkeeper) {
        this.awayLineupGoalkeeper = awayLineupGoalkeeper;
    }

    public HomeLineupDefense getHomeLineupDefense() {
        if (homeLineupDefense != null) {
            return homeLineupDefense;
        }
        else {
            return null;
        }
    }

    public void setHomeLineupDefense(HomeLineupDefense homeLineupDefense) {
        this.homeLineupDefense = homeLineupDefense;
    }

    public AwayLineupDefense getAwayLineupDefense() {
        if (awayLineupDefense != null) {
            return awayLineupDefense;
        }
        else {
            return null;
        }
    }

    public void setAwayLineupDefense(AwayLineupDefense awayLineupDefense) {
        this.awayLineupDefense = awayLineupDefense;
    }

    public HomeLineupMidfield getHomeLineupMidfield() {
        if (homeLineupMidfield != null) {
            return homeLineupMidfield;
        }
        else {
            return null;
        }
    }

    public void setHomeLineupMidfield(HomeLineupMidfield homeLineupMidfield) {
        this.homeLineupMidfield = homeLineupMidfield;
    }

    public AwayLineupMidfield getAwayLineupMidfield() {
        if (awayLineupMidfield != null) {
            return awayLineupMidfield;
        }
        else {
            return null;
        }
    }

    public void setAwayLineupMidfield(AwayLineupMidfield awayLineupMidfield) {
        this.awayLineupMidfield = awayLineupMidfield;
    }

    public HomeLineupForward getHomeLineupForward() {
        if (homeLineupForward != null) {
            return homeLineupForward;
        }
        else {
            return null;
        }
    }

    public void setHomeLineupForward(HomeLineupForward homeLineupForward) {
        this.homeLineupForward = homeLineupForward;
    }

    public AwayLineupForward getAwayLineupForward() {
        if (awayLineupForward != null) {
            return awayLineupForward;
        }
        else {
            return null;
        }
    }

    public void setAwayLineupForward(AwayLineupForward awayLineupForward) {
        this.awayLineupForward = awayLineupForward;
    }

    public HomeLineupSubstitutes getHomeLineupSubstitutes() {
        if (homeLineupSubstitutes != null) {
            return homeLineupSubstitutes;
        }
        else {
            return null;
        }
    }

    public void setHomeLineupSubstitutes(HomeLineupSubstitutes homeLineupSubstitutes) {
        this.homeLineupSubstitutes = homeLineupSubstitutes;
    }

    public AwayLineupSubstitutes getAwayLineupSubstitutes() {
        if (awayLineupSubstitutes != null) {
            return awayLineupSubstitutes;
        }
        else {
            return null;
        }
    }

    public void setAwayLineupSubstitutes(AwayLineupSubstitutes awayLineupSubstitutes) {
        this.awayLineupSubstitutes = awayLineupSubstitutes;
    }

    public HomeLineupCoach getHomeLineupCoach() {
        if (homeLineupCoach != null) {
            return homeLineupCoach;
        }
        else {
            return null;
        }
    }

    public void setHomeLineupCoach(HomeLineupCoach homeLineupCoach) {
        this.homeLineupCoach = homeLineupCoach;
    }

    public AwayLineupCoach getAwayLineupCoach() {
        if (awayLineupCoach != null) {
            return awayLineupCoach;
        }
        else {
            return null;
        }
    }

    public void setAwayLineupCoach(AwayLineupCoach awayLineupCoach) {
        this.awayLineupCoach = awayLineupCoach;
    }

    public HomeSubDetails getHomeSubDetails() {
        if (homeSubDetails != null) {
            return homeSubDetails;
        }
        else {
            return null;
        }
    }

    public void setHomeSubDetails(HomeSubDetails homeSubDetails) {
        this.homeSubDetails = homeSubDetails;
    }

    public AwaySubDetails getAwaySubDetails() {
        if (awaySubDetails != null) {
            return awaySubDetails;
        }
        else {
            return null;
        }
    }

    public void setAwaySubDetails(AwaySubDetails awaySubDetails) {
        this.awaySubDetails = awaySubDetails;
    }

    public String getHomeTeamFormation() {
        if (homeTeamFormation != null) {
            return homeTeamFormation;
        }
        else {
            return "";
        }
    }

    public void setHomeTeamFormation(String homeTeamFormation) {
        this.homeTeamFormation = homeTeamFormation;
    }

    public String getAwayTeamFormation() {
        if (awayTeamFormation!= null) {
            return awayTeamFormation;
        }
        else {
            return "";
        }
    }

    public void setAwayTeamFormation(String awayTeamFormation) {
        this.awayTeamFormation = awayTeamFormation;
    }

    public String getLocation() {
        if (location != null) {
            return location;
        }
        else {
            return "";
        }
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStadium() {
        if (stadium != null) {
            return stadium;
        }
        else {
            return "";
        }
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public String getHomeTeamYellowCardDetails() {
        if (homeTeamYellowCardDetails != null) {
            return homeTeamYellowCardDetails;
        }
        else {
            return "";
        }
    }

    public void setHomeTeamYellowCardDetails(String homeTeamYellowCardDetails) {
        this.homeTeamYellowCardDetails = homeTeamYellowCardDetails;
    }

    public String getAwayTeamYellowCardDetails() {
        if (awayTeamYellowCardDetails != null) {
            return awayTeamYellowCardDetails;
        }
        else {
            return "";
        }
    }

    public void setAwayTeamYellowCardDetails(String awayTeamYellowCardDetails) {
        this.awayTeamYellowCardDetails = awayTeamYellowCardDetails;
    }

    public String getHomeTeamRedCardDetails() {
        if (homeTeamRedCardDetails != null) {
            return homeTeamRedCardDetails;
        }
        else {
            return "";
        }
    }

    public void setHomeTeamRedCardDetails(String homeTeamRedCardDetails) {
        this.homeTeamRedCardDetails = homeTeamRedCardDetails;
    }

    public String getAwayTeamRedCardDetails() {

        if (awayTeamRedCardDetails != null) {
            return awayTeamRedCardDetails;
        }
        else {
            return "";
        }
    }

    public void setAwayTeamRedCardDetails(String awayTeamRedCardDetails) {
        this.awayTeamRedCardDetails = awayTeamRedCardDetails;
    }

    public String getReferee() {
        if (referee != null) {
            return referee;
        }
        else {
            return "";
        }
    }

    public void setReferee(String referee) {
        this.referee = referee;
    }

    public String getHasBeenRescheduled() {
        if (hasBeenRescheduled != null) {
            return hasBeenRescheduled;
        }
        else {
            return "";
        }
    }

    public void setHasBeenRescheduled(String hasBeenRescheduled) {
        this.hasBeenRescheduled = hasBeenRescheduled;
    }

}