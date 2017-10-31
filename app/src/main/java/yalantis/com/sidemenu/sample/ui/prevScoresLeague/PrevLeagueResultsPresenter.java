package yalantis.com.sidemenu.sample.ui.prevScoresLeague;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import yalantis.com.sidemenu.sample.DataManager;
import yalantis.com.sidemenu.sample.network.model.leaguePreResults.LeaguesPrev;
import yalantis.com.sidemenu.sample.ui.base.BasePresenter;
import yalantis.com.sidemenu.sample.ui.utils.rx.SchedulerProvider;

/**
 * Created by TheAppExperts on 30/10/2017.
 */

public class PrevLeagueResultsPresenter
        <V extends IPrevLeagueResultsMvpView>
        extends BasePresenter<V>
        implements IPrevLeagueResultsMvpPresenter<V> {


    @Inject
    public PrevLeagueResultsPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onViewPrepared(String id) {
        getCompositeDisposable().add(getDataManager()
                .useCasePreviousLeagueResults(id)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<LeaguesPrev>() {
                               @Override
                               public void accept(@NonNull LeaguesPrev leaguesPrev) throws Exception {
                                   getMvpView().onFetchPrevResultsCompleted(leaguesPrev);
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
