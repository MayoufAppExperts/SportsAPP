package yalantis.com.sidemenu.sample.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import yalantis.com.sidemenu.sample.R;
import yalantis.com.sidemenu.sample.network.model.leagueNextFix.LeaguesNext;
import yalantis.com.sidemenu.sample.sdi.component.IActivityComponent;
import yalantis.com.sidemenu.sample.ui.base.BaseFragment;
import yalantis.com.sidemenu.sample.ui.nextLeague.INextLeagueFixMvpView;
import yalantis.com.sidemenu.sample.ui.nextLeague.NextLeagueFixPresenter;

//import yalantis.com.sidemenu.sample.sdi.component.DaggerIActivityComponent;

/**
 * Created by TheAppExperts on 31/10/2017.
 */

public class NextLeagueFixFrag extends BaseFragment implements INextLeagueFixMvpView {


    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @BindView(R.id.swipeRefresh)
    SwipeRefreshLayout mySwipeRefreshLayout;


    IActivityComponent iActivityComponent;

    public IActivityComponent getiActivityComponent() {
        return iActivityComponent;
    }

    @Inject
    NextLeagueFixPresenter<INextLeagueFixMvpView> viewNextLeagueFixPresenter;

    String id = "";

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

        id = getArguments().getString("id");

        Log.i("NextFix","ID is " + id);

        viewNextLeagueFixPresenter.onAttach(this);
        viewNextLeagueFixPresenter.onViewPrepared(id);

        super.onViewCreated(view, savedInstanceState);
    }

    private void initialiseDagger() {/*
        iActivityComponent = DaggerIActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .iApplicationComponent(((MyApp) getApplication()).getiApplicationComponent())
                .build();

        getiActivityComponent().inject(this);*/
    }

    private void initialiseRecyclerView(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        Log.d("Recycler View", "Initialised True");
    }

    @Override
    public void onError(String message) {
        Log.i("errornext", message);
    }

    @Override
    public void onFetchNextLeagueCompleted(LeaguesNext leaguesNext) {
        recyclerView.setAdapter(new LeaguesNextAdapter(leaguesNext, R.layout.live_score, getActivity().getApplicationContext()));
    }
}
