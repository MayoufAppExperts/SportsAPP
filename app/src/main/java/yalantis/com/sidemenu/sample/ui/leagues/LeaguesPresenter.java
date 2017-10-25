package yalantis.com.sidemenu.sample.ui.leagues;


import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import yalantis.com.sidemenu.sample.DataManager;
import yalantis.com.sidemenu.sample.network.model.FootballModel;
import yalantis.com.sidemenu.sample.ui.base.BasePresenter;
import yalantis.com.sidemenu.sample.ui.utils.rx.SchedulerProvider;

/**
 * Created by TheAppExperts on 18/10/2017.
 */

public class LeaguesPresenter
        <V extends ILeaguesMvpView>
        extends BasePresenter<V>
        implements ILeaguesMvpPresenter<V> {


    @Inject
    public LeaguesPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onViewPrepared() {

        getCompositeDisposable().add(getDataManager()
                .useCaseLeagueList()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<FootballModel>() {
                               @Override
                               public void accept(@NonNull FootballModel footballModel) throws Exception {
                                   getMvpView().onFetchLeagueCompleted(footballModel);
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
