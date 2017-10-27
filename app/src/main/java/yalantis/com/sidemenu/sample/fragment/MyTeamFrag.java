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

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.disposables.CompositeDisposable;
import yalantis.com.sidemenu.sample.AppDataManager;
import yalantis.com.sidemenu.sample.R;
import yalantis.com.sidemenu.sample.network.model.myteam.MyTeamModel;
import yalantis.com.sidemenu.sample.network.model.myteam.Team;
import yalantis.com.sidemenu.sample.network.service.OnTeamInfoClickListener;
import yalantis.com.sidemenu.sample.ui.base.BaseFragment;
import yalantis.com.sidemenu.sample.ui.myTeam.IMyTeamMvpView;
import yalantis.com.sidemenu.sample.ui.myTeam.MyTeamPresenter;
import yalantis.com.sidemenu.sample.ui.utils.rx.AppSchedulerProvider;

/**
 * Created by TheAppExperts on 17/10/2017.
 */

public class MyTeamFrag extends BaseFragment implements IMyTeamMvpView {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @BindView(R.id.swipeRefresh)
    SwipeRefreshLayout mySwipeRefreshLayout;


    MyTeamPresenter<IMyTeamMvpView> mvpViewMyTeamPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
        //return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        ButterKnife.bind(this, view);
        initialiseRecyclerView(view);

        mvpViewMyTeamPresenter = new MyTeamPresenter<>(
                new AppDataManager(),
                new AppSchedulerProvider(),
                new CompositeDisposable());

        mvpViewMyTeamPresenter.onAttach(this);
        mvpViewMyTeamPresenter.onViewPrepared();

        super.onViewCreated(view, savedInstanceState);
    }

    private void initialiseRecyclerView(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        Log.d("Recycler View", "Initialised True");
    }


    private void swipeRefresh(View view) {

        //mySwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefresh);
        mySwipeRefreshLayout.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        Toast.makeText(getActivity().getApplicationContext(), "Refreshed", Toast.LENGTH_LONG);
                        myUpdateOperation();
                        initialiseRecyclerView(view);
                    }

                    public void myUpdateOperation() {

                        mySwipeRefreshLayout.setRefreshing(true);
                    }
                });
    }

    @Override
    public void onFetchMyTeamCompleted(MyTeamModel myTeamModel) {
        //Log.d("myteam", myTeamModel.getTeams().get(1).getStrTeam());
        recyclerView.setAdapter(new MyTeamAdapter(myTeamModel, R.layout.row, getActivity().getApplicationContext(), new OnTeamInfoClickListener() {
            @Override
            public void onItemClick(Team team) {
                Log.i("check","blah");
            }
        }));
        Log.i("Fetch", "Completed");

    }
}
