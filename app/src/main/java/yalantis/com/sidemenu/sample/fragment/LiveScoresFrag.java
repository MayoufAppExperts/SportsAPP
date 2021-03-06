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
import android.widget.Toast;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import yalantis.com.sidemenu.sample.MyApp;
import yalantis.com.sidemenu.sample.R;
import yalantis.com.sidemenu.sample.network.model.livescores.LiveScores;
import yalantis.com.sidemenu.sample.sdi.component.DaggerIActivityComponent;
import yalantis.com.sidemenu.sample.sdi.component.IActivityComponent;
import yalantis.com.sidemenu.sample.sdi.module.ActivityModule;
import yalantis.com.sidemenu.sample.ui.base.BaseFragment;
import yalantis.com.sidemenu.sample.ui.liveScores.ILiveScoresMvpView;
import yalantis.com.sidemenu.sample.ui.liveScores.LiveScoresPresenter;

import static yalantis.com.sidemenu.sample.MyApp.getApplication;

//import yalantis.com.sidemenu.sample.sdi.component.DaggerIActivityComponent;

/**
 * Created by TheAppExperts on 23/10/2017.
 */

public class LiveScoresFrag extends BaseFragment implements ILiveScoresMvpView {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @BindView(R.id.swipeRefresh)
    SwipeRefreshLayout mySwipeRefreshLayout;


    IActivityComponent iActivityComponent;

    public IActivityComponent getiActivityComponent() {
        return iActivityComponent;
    }

    @Inject
    LiveScoresPresenter<ILiveScoresMvpView> viewLiveScoresPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d("Class Loaded", "Sports");
        return inflater.inflate(R.layout.fragment_main, container, false);
        //return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Log.d("Class Loaded", "Sports");
        ButterKnife.bind(this, view);
        initialiseRecyclerView(view);
        initialiseDagger();

        viewLiveScoresPresenter.onAttach(this);
        viewLiveScoresPresenter.onViewPrepared();

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
        Log.i("blahlive", "Initialised True");
    }


    private void swipeRefresh(View view) {

        //mySwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefresh);
        mySwipeRefreshLayout.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        refreshItems();
                        Toast.makeText(getActivity().getApplicationContext(), "Refreshed", Toast.LENGTH_LONG);
                        myUpdateOperation();
                        initialiseRecyclerView(view);
                    }

                    public void myUpdateOperation() {

                        mySwipeRefreshLayout.setRefreshing(false);
                    }
                });
    }

    private void refreshItems() {
        viewLiveScoresPresenter.onAttach(this);
        viewLiveScoresPresenter.onViewPrepared();
    }

    @Override
    public void onLiveScoresFetchCompleted(LiveScores liveScores) {
        //
        Log.i("blahblah", liveScores.getTeams().getMatch().get(0).getHomeTeam());
        //recyclerView.setAdapter(new LiveScoreAdapter(liveScores, R.layout.live_score, getActivity().getApplicationContext()));
        Log.i("Live Scores", "Completed");

    }

    @Override
    public void onError(String message) {
        Log.i("errorlive", message);
    }
}
