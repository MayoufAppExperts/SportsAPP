package yalantis.com.sidemenu.sample.ui.myTeam;


import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import yalantis.com.sidemenu.sample.DataManager;
import yalantis.com.sidemenu.sample.network.model.MyTeamModel;
import yalantis.com.sidemenu.sample.ui.base.BasePresenter;
import yalantis.com.sidemenu.sample.ui.utils.rx.SchedulerProvider;

/**
 * Created by TheAppExperts on 19/10/2017.
 */

public class MyTeamPresenter
    <V extends IMyTeamMvpView>
    extends BasePresenter<V>
    implements IMyTeamMvpPresenter<V>{


    public MyTeamPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onViewPrepared() {

        getCompositeDisposable().add(getDataManager()
                .useCaseMyTeam()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<MyTeamModel>() {
                               @Override
                               public void accept(@NonNull MyTeamModel myTeamModel) throws Exception {
                                   getMvpView().onFetchMyTeamCompleted(myTeamModel);
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
