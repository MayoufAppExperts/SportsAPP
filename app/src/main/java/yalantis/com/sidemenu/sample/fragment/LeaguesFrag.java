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


import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.disposables.CompositeDisposable;
import yalantis.com.sidemenu.sample.AppDataManager;
import yalantis.com.sidemenu.sample.R;
import yalantis.com.sidemenu.sample.network.model.Country;
import yalantis.com.sidemenu.sample.network.model.FootballModel;
import yalantis.com.sidemenu.sample.network.model.MyTeamModel;
import yalantis.com.sidemenu.sample.network.service.OnItemClickListener;
import yalantis.com.sidemenu.sample.ui.base.BaseFragment;
import yalantis.com.sidemenu.sample.ui.leagues.ILeaguesMvpView;
import yalantis.com.sidemenu.sample.ui.leagues.LeaguesPresenter;
import yalantis.com.sidemenu.sample.ui.utils.rx.AppSchedulerProvider;


public class LeaguesFrag extends BaseFragment implements ILeaguesMvpView {


    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;/*
    @BindView(R.id.swipeRefresh)
    SwipeRefreshLayout swipeRefreshLayout;*/

    LeaguesPresenter<ILeaguesMvpView> viewLeaguesPresenter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        ButterKnife.bind(this, view);
        initialiseRecyclerView(view);

        viewLeaguesPresenter = new LeaguesPresenter<>(
                new AppDataManager(),
                new AppSchedulerProvider(),
                new CompositeDisposable());

        viewLeaguesPresenter.onAttach(this);
        viewLeaguesPresenter.onViewPrepared();



        super.onViewCreated(view, savedInstanceState);
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
