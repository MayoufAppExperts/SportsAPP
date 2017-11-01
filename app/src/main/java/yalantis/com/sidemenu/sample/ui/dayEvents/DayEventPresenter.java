package yalantis.com.sidemenu.sample.ui.dayEvents;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import yalantis.com.sidemenu.sample.DataManager;
import yalantis.com.sidemenu.sample.network.model.leaguePreResults.LeaguesPrev;
import yalantis.com.sidemenu.sample.ui.base.BasePresenter;
import yalantis.com.sidemenu.sample.ui.utils.rx.SchedulerProvider;

/**
 * Created by TheAppExperts on 31/10/2017.
 */

public class DayEventPresenter
    <V extends IDayEventMvpView>
    extends BasePresenter<V>
    implements IDayEventMvpPresenter<V>{


    @Inject
    public DayEventPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onViewPrepared(String d) {
        getCompositeDisposable().add(getDataManager()
                .useCaseDayEvents(d)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<LeaguesPrev>() {
                               @Override
                               public void accept(@NonNull LeaguesPrev leaguesPrev) throws Exception {
                                   getMvpView().onFetchDayEventCompleted(leaguesPrev);
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
