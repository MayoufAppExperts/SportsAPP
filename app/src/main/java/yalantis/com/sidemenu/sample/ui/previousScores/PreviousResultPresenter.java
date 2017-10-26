package yalantis.com.sidemenu.sample.ui.previousScores;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import yalantis.com.sidemenu.sample.DataManager;
import yalantis.com.sidemenu.sample.network.model.previousModel.PreviousFixtures;
import yalantis.com.sidemenu.sample.ui.base.BasePresenter;
import yalantis.com.sidemenu.sample.ui.liveScores.ILiveScoresMvpPresenter;
import yalantis.com.sidemenu.sample.ui.utils.rx.SchedulerProvider;

/**
 * Created by TheAppExperts on 25/10/2017.
 */

public class PreviousResultPresenter
        <V extends IPreviousResultMvpView>
        extends BasePresenter<V>
        implements IPreviousResultMvpPresenter<V> {


    @Inject
    public PreviousResultPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onViewPrepared(String id) {
        getCompositeDisposable().add(getDataManager()
                .useCasePreviousFixtures(id)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<PreviousFixtures>() {
                               @Override
                               public void accept(@NonNull PreviousFixtures previousFixtures) throws Exception {
                                   getMvpView().onFetchPreviousResult(previousFixtures);
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
