package yalantis.com.sidemenu.sample.sdi.module;

import android.content.Context;
import android.support.v4.app.Fragment;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;
import yalantis.com.sidemenu.sample.ui.base.BaseFragment;
import yalantis.com.sidemenu.sample.ui.leagues.ILeaguesMvpPresenter;
import yalantis.com.sidemenu.sample.ui.leagues.ILeaguesMvpView;
import yalantis.com.sidemenu.sample.ui.leagues.LeaguesPresenter;
import yalantis.com.sidemenu.sample.ui.liveScores.ILiveScoresMvpPresenter;
import yalantis.com.sidemenu.sample.ui.liveScores.ILiveScoresMvpView;
import yalantis.com.sidemenu.sample.ui.liveScores.LiveScoresPresenter;
import yalantis.com.sidemenu.sample.ui.teamInfo.ITeamInfoMvpPresenter;
import yalantis.com.sidemenu.sample.ui.teamInfo.ITeamInfoMvpView;
import yalantis.com.sidemenu.sample.ui.teamInfo.TeamInfoPresenter;
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
    ILeaguesMvpPresenter<ILeaguesMvpView> iLeaguesMvpViewILeaguesMvpPresenter (LeaguesPresenter<ILeaguesMvpView> leaguesPresenter){
        return leaguesPresenter;
    }

    @Provides
    ILiveScoresMvpPresenter<ILiveScoresMvpView> iLiveScoresMvpViewILiveScoresMvpPresenter (LiveScoresPresenter<ILiveScoresMvpView> scoresPresenter){
        return scoresPresenter;
    }

    @Provides
    ITeamInfoMvpPresenter<ITeamInfoMvpView> iTeamInfoMvpViewITeamInfoMvpPresenter(TeamInfoPresenter<ITeamInfoMvpView> teamInfoPresenter){
        return teamInfoPresenter;

    }
}

