package yalantis.com.sidemenu.sample.network.model.livescores;

/**
 * Created by TheAppExperts on 23/10/2017.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import yalantis.com.sidemenu.sample.network.model.livescores.HomeTeamYellowCardDetails;

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
    private String homeLineupCoach;
    @SerializedName("AwayLineupCoach")
    @Expose
    private String awayLineupCoach;
    @SerializedName("HomeSubDetails")
    @Expose
    private HomeSubDetails homeSubDetails;
    @SerializedName("AwaySubDetails")
    @Expose
    private AwaySubDetails awaySubDetails;
    @SerializedName("HomeTeamFormation")
    @Expose
    private HomeTeamFormation homeTeamFormation;
    @SerializedName("AwayTeamFormation")
    @Expose
    private AwayTeamFormation awayTeamFormation;
    @SerializedName("Location")
    @Expose
    private String location;
    @SerializedName("Stadium")
    @Expose
    private String stadium;
    @SerializedName("HomeTeamYellowCardDetails")
    @Expose
    private HomeTeamYellowCardDetails homeTeamYellowCardDetails;
    @SerializedName("AwayTeamYellowCardDetails")
    @Expose
    private AwayTeamYellowCardDetails awayTeamYellowCardDetails;
    @SerializedName("HomeTeamRedCardDetails")
    @Expose
    private HomeTeamRedCardDetails homeTeamRedCardDetails;
    @SerializedName("AwayTeamRedCardDetails")
    @Expose
    private AwayTeamRedCardDetails awayTeamRedCardDetails;
    @SerializedName("HasBeenRescheduled")
    @Expose
    private String hasBeenRescheduled;
    @SerializedName("Referee")
    @Expose
    private String referee;

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

    public AwayTeamId getAwayTeamId() {
        return awayTeamId;
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
        return homeGoalDetails;
    }

    public void setHomeGoalDetails(HomeGoalDetails homeGoalDetails) {
        this.homeGoalDetails = homeGoalDetails;
    }

    public AwayGoalDetails getAwayGoalDetails() {
        return awayGoalDetails;
    }

    public void setAwayGoalDetails(AwayGoalDetails awayGoalDetails) {
        this.awayGoalDetails = awayGoalDetails;
    }

    public HomeLineupGoalkeeper getHomeLineupGoalkeeper() {
        return homeLineupGoalkeeper;
    }

    public void setHomeLineupGoalkeeper(HomeLineupGoalkeeper homeLineupGoalkeeper) {
        this.homeLineupGoalkeeper = homeLineupGoalkeeper;
    }

    public AwayLineupGoalkeeper getAwayLineupGoalkeeper() {
        return awayLineupGoalkeeper;
    }

    public void setAwayLineupGoalkeeper(AwayLineupGoalkeeper awayLineupGoalkeeper) {
        this.awayLineupGoalkeeper = awayLineupGoalkeeper;
    }

    public HomeLineupDefense getHomeLineupDefense() {
        return homeLineupDefense;
    }

    public void setHomeLineupDefense(HomeLineupDefense homeLineupDefense) {
        this.homeLineupDefense = homeLineupDefense;
    }

    public AwayLineupDefense getAwayLineupDefense() {
        return awayLineupDefense;
    }

    public void setAwayLineupDefense(AwayLineupDefense awayLineupDefense) {
        this.awayLineupDefense = awayLineupDefense;
    }

    public HomeLineupMidfield getHomeLineupMidfield() {
        return homeLineupMidfield;
    }

    public void setHomeLineupMidfield(HomeLineupMidfield homeLineupMidfield) {
        this.homeLineupMidfield = homeLineupMidfield;
    }

    public AwayLineupMidfield getAwayLineupMidfield() {
        return awayLineupMidfield;
    }

    public void setAwayLineupMidfield(AwayLineupMidfield awayLineupMidfield) {
        this.awayLineupMidfield = awayLineupMidfield;
    }

    public HomeLineupForward getHomeLineupForward() {
        return homeLineupForward;
    }

    public void setHomeLineupForward(HomeLineupForward homeLineupForward) {
        this.homeLineupForward = homeLineupForward;
    }

    public AwayLineupForward getAwayLineupForward() {
        return awayLineupForward;
    }

    public void setAwayLineupForward(AwayLineupForward awayLineupForward) {
        this.awayLineupForward = awayLineupForward;
    }

    public HomeLineupSubstitutes getHomeLineupSubstitutes() {
        return homeLineupSubstitutes;
    }

    public void setHomeLineupSubstitutes(HomeLineupSubstitutes homeLineupSubstitutes) {
        this.homeLineupSubstitutes = homeLineupSubstitutes;
    }

    public AwayLineupSubstitutes getAwayLineupSubstitutes() {
        return awayLineupSubstitutes;
    }

    public void setAwayLineupSubstitutes(AwayLineupSubstitutes awayLineupSubstitutes) {
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

    public HomeSubDetails getHomeSubDetails() {
        return homeSubDetails;
    }

    public void setHomeSubDetails(HomeSubDetails homeSubDetails) {
        this.homeSubDetails = homeSubDetails;
    }

    public AwaySubDetails getAwaySubDetails() {
        return awaySubDetails;
    }

    public void setAwaySubDetails(AwaySubDetails awaySubDetails) {
        this.awaySubDetails = awaySubDetails;
    }

    public HomeTeamFormation getHomeTeamFormation() {
        return homeTeamFormation;
    }

    public void setHomeTeamFormation(HomeTeamFormation homeTeamFormation) {
        this.homeTeamFormation = homeTeamFormation;
    }

    public AwayTeamFormation getAwayTeamFormation() {
        return awayTeamFormation;
    }

    public void setAwayTeamFormation(AwayTeamFormation awayTeamFormation) {
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

    public HomeTeamYellowCardDetails getHomeTeamYellowCardDetails() {
        return homeTeamYellowCardDetails;
    }

    public void setHomeTeamYellowCardDetails(HomeTeamYellowCardDetails homeTeamYellowCardDetails) {
        this.homeTeamYellowCardDetails = homeTeamYellowCardDetails;
    }

    public AwayTeamYellowCardDetails getAwayTeamYellowCardDetails() {
        return awayTeamYellowCardDetails;
    }

    public void setAwayTeamYellowCardDetails(AwayTeamYellowCardDetails awayTeamYellowCardDetails) {
        this.awayTeamYellowCardDetails = awayTeamYellowCardDetails;
    }

    public HomeTeamRedCardDetails getHomeTeamRedCardDetails() {
        return homeTeamRedCardDetails;
    }

    public void setHomeTeamRedCardDetails(HomeTeamRedCardDetails homeTeamRedCardDetails) {
        this.homeTeamRedCardDetails = homeTeamRedCardDetails;
    }

    public AwayTeamRedCardDetails getAwayTeamRedCardDetails() {
        return awayTeamRedCardDetails;
    }

    public void setAwayTeamRedCardDetails(AwayTeamRedCardDetails awayTeamRedCardDetails) {
        this.awayTeamRedCardDetails = awayTeamRedCardDetails;
    }

    public String getHasBeenRescheduled() {
        return hasBeenRescheduled;
    }

    public void setHasBeenRescheduled(String hasBeenRescheduled) {
        this.hasBeenRescheduled = hasBeenRescheduled;
    }

    public String getReferee() {
        return referee;
    }

    public void setReferee(String referee) {
        this.referee = referee;
    }

}