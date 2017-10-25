package yalantis.com.sidemenu.sample.ui.liveScores;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import yalantis.com.sidemenu.sample.DataManager;
import yalantis.com.sidemenu.sample.network.model.livescores.LiveScores;
import yalantis.com.sidemenu.sample.ui.base.BasePresenter;
import yalantis.com.sidemenu.sample.ui.utils.rx.SchedulerProvider;

/**
 * Created by TheAppExperts on 23/10/2017.
 */

public class LiveScoresPresenter
        <V extends ILiveScoresMvpView>
        extends BasePresenter<V>
        implements ILiveScoresMvpPresenter<V> {

    @Inject
    public LiveScoresPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }


    @Override
    public void onViewPrepared() {

        getCompositeDisposable().add(getDataManager()
                .useCaseLiveScores()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<LiveScores>() {
                               @Override
                               public void accept(@NonNull LiveScores liveScores) throws Exception {
                                   getMvpView().onLiveScoresFetchCompleted(liveScores);
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
