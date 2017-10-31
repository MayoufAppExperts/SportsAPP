package yalantis.com.sidemenu.sample.ui.nextLeague;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import yalantis.com.sidemenu.sample.DataManager;
import yalantis.com.sidemenu.sample.network.model.leagueNextFix.LeaguesNext;
import yalantis.com.sidemenu.sample.network.model.leaguePreResults.LeaguesPrev;
import yalantis.com.sidemenu.sample.ui.base.BaseFragment;
import yalantis.com.sidemenu.sample.ui.base.BasePresenter;
import yalantis.com.sidemenu.sample.ui.utils.rx.SchedulerProvider;

/**
 * Created by TheAppExperts on 31/10/2017.
 */

public class NextLeagueFixPresenter
        <V extends INextLeagueFixMvpView>
        extends BasePresenter<V>
        implements INextLeagueFixMvpPresenter<V> {


    @Inject
    public NextLeagueFixPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onViewPrepared(String id) {
        getCompositeDisposable().add(getDataManager()
                .useCaseNextLeagueFixtures(id)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<LeaguesNext>() {
                               @Override
                               public void accept(@NonNull LeaguesNext leaguesNext) throws Exception {
                                   getMvpView().onFetchNextLeagueCompleted(leaguesNext);
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
