package yalantis.com.sidemenu.sample.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
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
import io.reactivex.disposables.CompositeDisposable;
import yalantis.com.sidemenu.sample.AppDataManager;
import yalantis.com.sidemenu.sample.MyApp;
import yalantis.com.sidemenu.sample.R;
import yalantis.com.sidemenu.sample.network.model.Country;
import yalantis.com.sidemenu.sample.network.model.FootballModel;
import yalantis.com.sidemenu.sample.network.service.OnItemClickListener;
import yalantis.com.sidemenu.sample.sdi.component.DaggerIActivityComponent;
import yalantis.com.sidemenu.sample.sdi.component.IActivityComponent;
import yalantis.com.sidemenu.sample.sdi.module.ActivityModule;
import yalantis.com.sidemenu.sample.ui.base.BaseFragment;
import yalantis.com.sidemenu.sample.ui.leagues.ILeaguesMvpView;
import yalantis.com.sidemenu.sample.ui.leagues.LeaguesPresenter;
import yalantis.com.sidemenu.sample.ui.utils.rx.AppSchedulerProvider;

import static yalantis.com.sidemenu.sample.MyApp.getApplication;


public class LeaguesFrag extends BaseFragment implements ILeaguesMvpView {


    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @BindView(R.id.swipeRefresh)
    SwipeRefreshLayout mySwipeRefreshLayout;

    IActivityComponent iActivityComponent;

    public IActivityComponent getiActivityComponent() {
        return iActivityComponent;
    }

    @Inject
    LeaguesPresenter<ILeaguesMvpView> viewLeaguesPresenter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        ButterKnife.bind(this, view);
        initialiseRecyclerView(view);
        initialiseDagger();
/*

        viewLeaguesPresenter = new LeaguesPresenter<>(
                new AppDataManager(),
                new AppSchedulerProvider(),
                new CompositeDisposable());
*/

        viewLeaguesPresenter.onAttach(this);
        viewLeaguesPresenter.onViewPrepared();



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
        viewLeaguesPresenter.onAttach(this);
        viewLeaguesPresenter.onViewPrepared();

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
    public void onFetchLeagueCompleted(final FootballModel footballModel) {
        recyclerView.setAdapter(new FootballAdapter(footballModel, R.layout.row, getActivity().getApplicationContext(), new OnItemClickListener() {
            @Override
            public void onItemClick(Country country) {
                String cid = country.getIdLeague();
                Fragment fr =new TeamsInLeaguesFrag();
                FragmentManager fm=getFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                Bundle args = new Bundle();
                args.putString("id", cid);
                fr.setArguments(args);
                ft.replace(R.id.content_frame, fr);
                ft.commit();
            }
        }));
        Log.i("Fetch", "Completed");
    }
}
