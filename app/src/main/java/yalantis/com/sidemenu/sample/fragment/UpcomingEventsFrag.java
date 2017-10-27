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
import yalantis.com.sidemenu.sample.network.model.upcomingEvents.UpcomingEvents;
import yalantis.com.sidemenu.sample.sdi.component.DaggerIActivityComponent;
import yalantis.com.sidemenu.sample.sdi.component.IActivityComponent;
import yalantis.com.sidemenu.sample.sdi.module.ActivityModule;
import yalantis.com.sidemenu.sample.ui.base.BaseFragment;
import yalantis.com.sidemenu.sample.ui.upcomingEvents.IUpcomingEventsMvpView;
import yalantis.com.sidemenu.sample.ui.upcomingEvents.UpcomingEventsPresenter;

import static yalantis.com.sidemenu.sample.MyApp.getApplication;

/**
 * Created by TheAppExperts on 26/10/2017.
 */

public class UpcomingEventsFrag extends BaseFragment implements IUpcomingEventsMvpView{

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @BindView(R.id.swipeRefresh)
    SwipeRefreshLayout mySwipeRefreshLayout;


    IActivityComponent iActivityComponent;
    String id = "";

    public IActivityComponent getiActivityComponent() {
        return iActivityComponent;
    }

    @Inject
    UpcomingEventsPresenter<IUpcomingEventsMvpView> upcomingEventsPresenter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        ButterKnife.bind(this, view);
        initialiseRecyclerView(view);
        initialiseDagger();

        id = getArguments().getString("id");


        upcomingEventsPresenter.onAttach(this);
        upcomingEventsPresenter.onViewPrepared(id);

        super.onViewCreated(view, savedInstanceState);
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

                        mySwipeRefreshLayout.setRefreshing(true);
                    }
                });
    }

    private void refreshItems() {
        upcomingEventsPresenter.onAttach(this);
        upcomingEventsPresenter.onViewPrepared(id);

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
        //recyclerView.setAdapter(new CakeAdapter(customerModels, R.layout.row, getActivity()));
    }

    @Override
    public void onFetchUpcomingEvents(UpcomingEvents upcomingEvents) {
        recyclerView.setAdapter(new UpcomingEventsAdapter(upcomingEvents, R.layout.live_score, getActivity().getApplicationContext()));
    }
}
