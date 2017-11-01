package yalantis.com.sidemenu.sample.ui.teams_in_league;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import yalantis.com.sidemenu.sample.DataManager;
import yalantis.com.sidemenu.sample.network.model.myteam.MyTeamModel;
import yalantis.com.sidemenu.sample.ui.base.BasePresenter;
import yalantis.com.sidemenu.sample.ui.utils.rx.SchedulerProvider;

/**
 * Created by TheAppExperts on 23/10/2017.
 */

public class TeamsInLeaguePresenter
        <V extends ITeamsInLeagueMvpView>
        extends BasePresenter<V>
        implements ITeamsInLeagueMvpPresenter<V> {

    @Inject
    public TeamsInLeaguePresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onViewPrepared(String id) {

        getCompositeDisposable().add(getDataManager()
                .useCaseTeamsInLeague(id)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<MyTeamModel>() {
                               @Override
                               public void accept(@NonNull MyTeamModel myTeamModel) throws Exception {
                                   getMvpView().onFetchDataCompleted(myTeamModel);
                               }
                           },
                        new Consumer<Throwable>() {
                            @Override
                            public void accept(@NonNull Throwable throwable) throws Exception {
                                getMvpView().onError(throwable.getMessage());

                            }
                        }));

    }
}
