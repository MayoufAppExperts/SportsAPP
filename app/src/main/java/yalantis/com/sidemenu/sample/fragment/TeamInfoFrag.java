package yalantis.com.sidemenu.sample.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.disposables.CompositeDisposable;
import yalantis.com.sidemenu.sample.AppDataManager;
import yalantis.com.sidemenu.sample.MyApp;
import yalantis.com.sidemenu.sample.R;
import yalantis.com.sidemenu.sample.network.model.myteam.MyTeamModel;
import yalantis.com.sidemenu.sample.sdi.component.DaggerIActivityComponent;
import yalantis.com.sidemenu.sample.sdi.component.IActivityComponent;
import yalantis.com.sidemenu.sample.sdi.module.ActivityModule;
import yalantis.com.sidemenu.sample.ui.base.BaseFragment;
import yalantis.com.sidemenu.sample.ui.teamInfo.ITeamInfoMvpView;
import yalantis.com.sidemenu.sample.ui.teamInfo.TeamInfoPresenter;
import yalantis.com.sidemenu.sample.ui.utils.rx.AppSchedulerProvider;

import static yalantis.com.sidemenu.sample.MyApp.getApplication;

/**
 * Created by TheAppExperts on 23/10/2017.
 */

public class TeamInfoFrag extends BaseFragment implements ITeamInfoMvpView {
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    IActivityComponent iActivityComponent;

    public IActivityComponent getiActivityComponent() {
        return iActivityComponent;
    }

    @Inject
    TeamInfoPresenter<ITeamInfoMvpView> mvpViewTeamInfoPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
        //return super.onCreateView(inflater, container, savedInstanceState);
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        ButterKnife.bind(this, view);
        initialiseRecyclerView(view);
        initialiseDagger();

        String id = getArguments().getString("id");

        mvpViewTeamInfoPresenter.onAttach(this);
        mvpViewTeamInfoPresenter.onViewPrepared(id);

        super.onViewCreated(view, savedInstanceState);
    }

    private void initialiseDagger() {
        iActivityComponent = DaggerIActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .iApplicationComponent(((MyApp) getApplication()).getiApplicationComponent())
                .build();

        getiActivityComponent().inject(this);
    }

    private void initialiseRecyclerView(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        Log.d("Recycler View", "Initialised True");
    }

    @Override
    public void onFetchMyTeamCompleted(MyTeamModel myTeamModel) {
        recyclerView.setAdapter(new TeamInfoAdapter(myTeamModel, R.layout.team_info, getActivity().getApplicationContext()));
        Log.i("Fetch", "Completed");

    }
}
