package yalantis.com.sidemenu.sample.ui.leagueInfo;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import yalantis.com.sidemenu.sample.DataManager;
import yalantis.com.sidemenu.sample.network.model.leagueInfo.LeagueInfo;
import yalantis.com.sidemenu.sample.ui.base.BasePresenter;
import yalantis.com.sidemenu.sample.ui.utils.rx.SchedulerProvider;

/**
 * Created by TheAppExperts on 30/10/2017.
 */

public class LeagueInfoPresenter
        <V extends ILeagueInfoMvpView>
        extends BasePresenter<V>
        implements ILeagueInfoMvpPresenter<V> {

    @Inject
    public LeagueInfoPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onViewPrepared(String id) {
        getCompositeDisposable().add(getDataManager()
                .useCaseLeagueInfo(id)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<LeagueInfo>() {
                               @Override
                               public void accept(@NonNull LeagueInfo leagueInfo) throws Exception {
                                   getMvpView().onFetchLeagueInfoCompleted(leagueInfo);
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
