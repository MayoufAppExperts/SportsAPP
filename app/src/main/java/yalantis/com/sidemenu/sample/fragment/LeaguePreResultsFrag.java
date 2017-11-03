package yalantis.com.sidemenu.sample.fragment;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
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
import yalantis.com.sidemenu.sample.adapter.LeaguePreResultsAdapter;
import yalantis.com.sidemenu.sample.network.model.leaguePreResults.Event;
import yalantis.com.sidemenu.sample.network.model.leaguePreResults.LeaguesPrev;
import yalantis.com.sidemenu.sample.network.service.OnDayEventClickListener;
import yalantis.com.sidemenu.sample.sdi.component.DaggerIActivityComponent;
import yalantis.com.sidemenu.sample.sdi.component.IActivityComponent;
import yalantis.com.sidemenu.sample.sdi.module.ActivityModule;
import yalantis.com.sidemenu.sample.ui.base.BaseFragment;
import yalantis.com.sidemenu.sample.ui.prevScoresLeague.IPrevLeagueResultsMvpView;
import yalantis.com.sidemenu.sample.ui.prevScoresLeague.PrevLeagueResultsPresenter;

import static yalantis.com.sidemenu.sample.MyApp.getApplication;

//import yalantis.com.sidemenu.sample.sdi.component.DaggerIActivityComponent;

/**
 * Created by TheAppExperts on 30/10/2017.
 */

public class LeaguePreResultsFrag extends BaseFragment implements IPrevLeagueResultsMvpView {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @BindView(R.id.swipeRefresh)
    SwipeRefreshLayout mySwipeRefreshLayout;


    IActivityComponent iActivityComponent;

    public IActivityComponent getiActivityComponent() {
        return iActivityComponent;
    }

    @Inject
    PrevLeagueResultsPresenter<IPrevLeagueResultsMvpView> prevLeagueResultsPresenter;

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

        prevLeagueResultsPresenter.onAttach(this);
        prevLeagueResultsPresenter.onViewPrepared(id);

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
    public void onFetchPrevResultsCompleted(LeaguesPrev leaguesPrev) {

        recyclerView.setAdapter(new LeaguePreResultsAdapter(leaguesPrev, R.layout.live_score, getActivity().getApplicationContext(), new OnDayEventClickListener() {
            @Override
            public void onItemClick(View view, Event event) {
                Toast.makeText(getContext(), "CLICKED", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MediaStore.INTENT_ACTION_MEDIA_PLAY_FROM_SEARCH);
                intent.putExtra(SearchManager.QUERY, event.getStrEvent() + " " + event.getStrDate());
                intent.setPackage("com.google.android.youtube");
                startActivity(intent);

            }
        }));
    }
}
