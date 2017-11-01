package yalantis.com.sidemenu.sample.sdi.module;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;
import yalantis.com.sidemenu.sample.ui.base.BaseFragment;
import yalantis.com.sidemenu.sample.ui.dayEvents.DayEventPresenter;
import yalantis.com.sidemenu.sample.ui.dayEvents.IDayEventMvpPresenter;
import yalantis.com.sidemenu.sample.ui.dayEvents.IDayEventMvpView;
import yalantis.com.sidemenu.sample.ui.leagueInfo.ILeagueInfoMvpPresenter;
import yalantis.com.sidemenu.sample.ui.leagueInfo.ILeagueInfoMvpView;
import yalantis.com.sidemenu.sample.ui.leagueInfo.LeagueInfoPresenter;
import yalantis.com.sidemenu.sample.ui.leagues.ILeaguesMvpPresenter;
import yalantis.com.sidemenu.sample.ui.leagues.ILeaguesMvpView;
import yalantis.com.sidemenu.sample.ui.leagues.LeaguesPresenter;
import yalantis.com.sidemenu.sample.ui.liveScores.ILiveScoresMvpPresenter;
import yalantis.com.sidemenu.sample.ui.liveScores.ILiveScoresMvpView;
import yalantis.com.sidemenu.sample.ui.liveScores.LiveScoresPresenter;
import yalantis.com.sidemenu.sample.ui.nextLeague.INextLeagueFixMvpPresenter;
import yalantis.com.sidemenu.sample.ui.nextLeague.INextLeagueFixMvpView;
import yalantis.com.sidemenu.sample.ui.nextLeague.NextLeagueFixPresenter;
import yalantis.com.sidemenu.sample.ui.prevScoresLeague.IPrevLeagueResultsMvpPresenter;
import yalantis.com.sidemenu.sample.ui.prevScoresLeague.IPrevLeagueResultsMvpView;
import yalantis.com.sidemenu.sample.ui.prevScoresLeague.PrevLeagueResultsPresenter;
import yalantis.com.sidemenu.sample.ui.previousScores.IPreviousResultMvpPresenter;
import yalantis.com.sidemenu.sample.ui.previousScores.IPreviousResultMvpView;
import yalantis.com.sidemenu.sample.ui.previousScores.PreviousResultPresenter;
import yalantis.com.sidemenu.sample.ui.teamInfo.ITeamInfoMvpPresenter;
import yalantis.com.sidemenu.sample.ui.teamInfo.ITeamInfoMvpView;
import yalantis.com.sidemenu.sample.ui.teamInfo.TeamInfoPresenter;
import yalantis.com.sidemenu.sample.ui.upcomingEvents.IUpcomingEventsMvpPresenter;
import yalantis.com.sidemenu.sample.ui.upcomingEvents.IUpcomingEventsMvpView;
import yalantis.com.sidemenu.sample.ui.upcomingEvents.UpcomingEventsPresenter;
import yalantis.com.sidemenu.sample.ui.utils.rx.AppSchedulerProvider;
import yalantis.com.sidemenu.sample.ui.utils.rx.SchedulerProvider;

/**
 * Created by TheAppExperts on 24/10/2017.
 */

@Module
public class ActivityModule {

    BaseFragment fragment;

    public ActivityModule(BaseFragment fragment) {
        this.fragment = fragment;
    }


    @Provides
    BaseFragment getFragment() {
        return fragment;
    }

    @Provides
    CompositeDisposable getCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    SchedulerProvider getSchedulerProvider() {
        return new AppSchedulerProvider();
    }


    @Provides
    ILeaguesMvpPresenter<ILeaguesMvpView> iLeaguesMvpViewILeaguesMvpPresenter(LeaguesPresenter<ILeaguesMvpView> leaguesPresenter) {
        return leaguesPresenter;
    }

    @Provides
    ILiveScoresMvpPresenter<ILiveScoresMvpView> iLiveScoresMvpViewILiveScoresMvpPresenter(LiveScoresPresenter<ILiveScoresMvpView> scoresPresenter) {
        return scoresPresenter;
    }

    @Provides
    ITeamInfoMvpPresenter<ITeamInfoMvpView> iTeamInfoMvpViewITeamInfoMvpPresenter(TeamInfoPresenter<ITeamInfoMvpView> teamInfoPresenter) {
        return teamInfoPresenter;

    }

    @Provides
    IPreviousResultMvpPresenter<IPreviousResultMvpView> iPreviousResultMvpViewIPreviousResultMvpPresenter(PreviousResultPresenter<IPreviousResultMvpView> previousResultPresenter) {
        return previousResultPresenter;
    }

    @Provides
    IUpcomingEventsMvpPresenter<IUpcomingEventsMvpView> iUpcomingEventsMvpViewIUpcomingEventsMvpPresenter(UpcomingEventsPresenter<IUpcomingEventsMvpView> upcomingEventsPresenter) {
        return upcomingEventsPresenter;
    }

    @Provides
    ILeagueInfoMvpPresenter<ILeagueInfoMvpView> iLeagueInfoMvpViewILeagueInfoMvpPresenter(LeagueInfoPresenter<ILeagueInfoMvpView> leagueInfoPresenter) {
        return leagueInfoPresenter;
    }

    @Provides
    IPrevLeagueResultsMvpPresenter<IPrevLeagueResultsMvpView> iPrevLeagueResultsMvpPresenter(PrevLeagueResultsPresenter<IPrevLeagueResultsMvpView> leagueResultsPresenter) {
        return leagueResultsPresenter;
    }

    @Provides
    INextLeagueFixMvpPresenter<INextLeagueFixMvpView> iNextLeagueFixMvpPresenter (NextLeagueFixPresenter<INextLeagueFixMvpView> nextLeagueFixPresenter){
        return nextLeagueFixPresenter;
    }
    @Provides
    IDayEventMvpPresenter<IDayEventMvpView> iDayEventMvpPresenter (DayEventPresenter<IDayEventMvpView> dayEventPresenter){
        return dayEventPresenter;
    }
}

