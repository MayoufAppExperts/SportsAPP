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
    private String homeTeamId;
    @SerializedName("AwayTeam")
    @Expose
    private String awayTeam;
    @SerializedName("AwayTeam_Id")
    @Expose
    private String awayTeamId;
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
    private String homeGoalDetails;
    @SerializedName("AwayGoalDetails")
    @Expose
    private String awayGoalDetails;
    @SerializedName("HomeLineupGoalkeeper")
    @Expose
    private String homeLineupGoalkeeper;
    @SerializedName("AwayLineupGoalkeeper")
    @Expose
    private String awayLineupGoalkeeper;
    @SerializedName("HomeLineupDefense")
    @Expose
    private String homeLineupDefense;
    @SerializedName("AwayLineupDefense")
    @Expose
    private String awayLineupDefense;
    @SerializedName("HomeLineupMidfield")
    @Expose
    private String homeLineupMidfield;
    @SerializedName("AwayLineupMidfield")
    @Expose
    private String awayLineupMidfield;
    @SerializedName("HomeLineupForward")
    @Expose
    private String homeLineupForward;
    @SerializedName("AwayLineupForward")
    @Expose
    private String awayLineupForward;
    @SerializedName("HomeLineupSubstitutes")
    @Expose
    private String homeLineupSubstitutes;
    @SerializedName("AwayLineupSubstitutes")
    @Expose
    private String awayLineupSubstitutes;
    @SerializedName("HomeLineupCoach")
    @Expose
    private String homeLineupCoach;
    @SerializedName("AwayLineupCoach")
    @Expose
    private String awayLineupCoach;
    @SerializedName("HomeSubDetails")
    @Expose
    private String homeSubDetails;
    @SerializedName("AwaySubDetails")
    @Expose
    private String awaySubDetails;
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
    private AwayTeamRedCardDetails awayTeamRedCardDetails;
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
        return spectators;
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

    public String getHomeTeamId() {
        return homeTeamId;
    }

    public void setHomeTeamId(String homeTeamId) {
        this.homeTeamId = homeTeamId;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public String getAwayTeamId() {
        return awayTeamId;
    }

    public void setAwayTeamId(String awayTeamId) {
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

    public String getHomeGoalDetails() {
        return homeGoalDetails;
    }

    public void setHomeGoalDetails(String homeGoalDetails) {
        this.homeGoalDetails = homeGoalDetails;
    }

    public String getAwayGoalDetails() {
        return awayGoalDetails;
    }

    public void setAwayGoalDetails(String awayGoalDetails) {
        this.awayGoalDetails = awayGoalDetails;
    }

    public String getHomeLineupGoalkeeper() {
        return homeLineupGoalkeeper;
    }

    public void setHomeLineupGoalkeeper(String homeLineupGoalkeeper) {
        this.homeLineupGoalkeeper = homeLineupGoalkeeper;
    }

    public String getAwayLineupGoalkeeper() {
        return awayLineupGoalkeeper;
    }

    public void setAwayLineupGoalkeeper(String awayLineupGoalkeeper) {
        this.awayLineupGoalkeeper = awayLineupGoalkeeper;
    }

    public String getHomeLineupDefense() {
        return homeLineupDefense;
    }

    public void setHomeLineupDefense(String homeLineupDefense) {
        this.homeLineupDefense = homeLineupDefense;
    }

    public String getAwayLineupDefense() {
        return awayLineupDefense;
    }

    public void setAwayLineupDefense(String awayLineupDefense) {
        this.awayLineupDefense = awayLineupDefense;
    }

    public String getHomeLineupMidfield() {
        return homeLineupMidfield;
    }

    public void setHomeLineupMidfield(String homeLineupMidfield) {
        this.homeLineupMidfield = homeLineupMidfield;
    }

    public String getAwayLineupMidfield() {
        return awayLineupMidfield;
    }

    public void setAwayLineupMidfield(String awayLineupMidfield) {
        this.awayLineupMidfield = awayLineupMidfield;
    }

    public String getHomeLineupForward() {
        return homeLineupForward;
    }

    public void setHomeLineupForward(String homeLineupForward) {
        this.homeLineupForward = homeLineupForward;
    }

    public String getAwayLineupForward() {
        return awayLineupForward;
    }

    public void setAwayLineupForward(String awayLineupForward) {
        this.awayLineupForward = awayLineupForward;
    }

    public String getHomeLineupSubstitutes() {
        return homeLineupSubstitutes;
    }

    public void setHomeLineupSubstitutes(String homeLineupSubstitutes) {
        this.homeLineupSubstitutes = homeLineupSubstitutes;
    }

    public String getAwayLineupSubstitutes() {
        return awayLineupSubstitutes;
    }

    public void setAwayLineupSubstitutes(String awayLineupSubstitutes) {
        this.awayLineupSubstitutes = awayLineupSubstitutes;
    }

    public String getHomeLineupCoach() {
        return homeLineupCoach;
    }

    public void setHomeLineupCoach(String homeLineupCoach) {
        this.homeLineupCoach = homeLineupCoach;
    }

    public String getAwayLineupCoach() {
        return awayLineupCoach;
    }

    public void setAwayLineupCoach(String awayLineupCoach) {
        this.awayLineupCoach = awayLineupCoach;
    }

    public String getHomeSubDetails() {
        return homeSubDetails;
    }

    public void setHomeSubDetails(String homeSubDetails) {
        this.homeSubDetails = homeSubDetails;
    }

    public String getAwaySubDetails() {
        return awaySubDetails;
    }

    public void setAwaySubDetails(String awaySubDetails) {
        this.awaySubDetails = awaySubDetails;
    }

    public String getHomeTeamFormation() {
        return homeTeamFormation;
    }

    public void setHomeTeamFormation(String homeTeamFormation) {
        this.homeTeamFormation = homeTeamFormation;
    }

    public String getAwayTeamFormation() {
        return awayTeamFormation;
    }

    public void setAwayTeamFormation(String awayTeamFormation) {
        this.awayTeamFormation = awayTeamFormation;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public String getHomeTeamYellowCardDetails() {
        return homeTeamYellowCardDetails;
    }

    public void setHomeTeamYellowCardDetails(String homeTeamYellowCardDetails) {
        this.homeTeamYellowCardDetails = homeTeamYellowCardDetails;
    }

    public String getAwayTeamYellowCardDetails() {
        return awayTeamYellowCardDetails;
    }

    public void setAwayTeamYellowCardDetails(String awayTeamYellowCardDetails) {
        this.awayTeamYellowCardDetails = awayTeamYellowCardDetails;
    }

    public String getHomeTeamRedCardDetails() {
        return homeTeamRedCardDetails;
    }

    public void setHomeTeamRedCardDetails(String homeTeamRedCardDetails) {
        this.homeTeamRedCardDetails = homeTeamRedCardDetails;
    }

    public AwayTeamRedCardDetails getAwayTeamRedCardDetails() {
        return awayTeamRedCardDetails;
    }

    public void setAwayTeamRedCardDetails(AwayTeamRedCardDetails awayTeamRedCardDetails) {
        this.awayTeamRedCardDetails = awayTeamRedCardDetails;
    }

    public String getReferee() {
        return referee;
    }

    public void setReferee(String referee) {
        this.referee = referee;
    }

    public String getHasBeenRescheduled() {
        return hasBeenRescheduled;
    }

    public void setHasBeenRescheduled(String hasBeenRescheduled) {
        this.hasBeenRescheduled = hasBeenRescheduled;
    }

}