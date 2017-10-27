package yalantis.com.sidemenu.sample.ui.upcomingEvents;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import yalantis.com.sidemenu.sample.DataManager;
import yalantis.com.sidemenu.sample.network.model.upcomingEvents.UpcomingEvents;
import yalantis.com.sidemenu.sample.ui.base.BasePresenter;
import yalantis.com.sidemenu.sample.ui.utils.rx.SchedulerProvider;

/**
 * Created by TheAppExperts on 26/10/2017.
 */

public class UpcomingEventsPresenter
        <V extends IUpcomingEventsMvpView>
        extends BasePresenter<V>
        implements IUpcomingEventsMvpPresenter<V> {

    @Inject
    public UpcomingEventsPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onViewPrepared(String id) {
        getCompositeDisposable().add(getDataManager()
                .useCaseUpcomingEvents(id)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<UpcomingEvents>() {
                               @Override
                               public void accept(@NonNull UpcomingEvents upcomingEvents) throws Exception {
                                   getMvpView().onFetchUpcomingEvents(upcomingEvents);
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
