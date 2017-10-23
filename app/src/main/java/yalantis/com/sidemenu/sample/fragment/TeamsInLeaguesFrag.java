package yalantis.com.sidemenu.sample.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
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
import yalantis.com.sidemenu.sample.network.model.MyTeamModel;
import yalantis.com.sidemenu.sample.network.model.Team;
import yalantis.com.sidemenu.sample.network.service.OnItemClickListener;
import yalantis.com.sidemenu.sample.network.service.OnTeamInfoClickListener;
import yalantis.com.sidemenu.sample.ui.base.BaseFragment;
import yalantis.com.sidemenu.sample.ui.teams_in_league.ITeamsInLeagueMvpView;
import yalantis.com.sidemenu.sample.ui.teams_in_league.TeamsInLeaguePresenter;
import yalantis.com.sidemenu.sample.ui.utils.rx.AppSchedulerProvider;

/**
 * Created by TheAppExperts on 23/10/2017.
 */

public class TeamsInLeaguesFrag extends BaseFragment  implements ITeamsInLeagueMvpView{

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    TeamsInLeaguePresenter <ITeamsInLeagueMvpView> teamsInLeaguePresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
        //return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        ButterKnife.bind(this, view);
        initialiseRecyclerView(view);

        String id = getArguments().getString("id");

        teamsInLeaguePresenter = new TeamsInLeaguePresenter<>(
                new AppDataManager(),
                new AppSchedulerProvider(),
                new CompositeDisposable());

        teamsInLeaguePresenter.onAttach(this);
        teamsInLeaguePresenter.onViewPrepared(id);

        super.onViewCreated(view, savedInstanceState);
    }

    private void initialiseRecyclerView(View view) {

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        Log.d("Recycler View", "Initialised True");
    }

    @Override
    public void onFetchDataCompleted(MyTeamModel myTeamModel) {
        recyclerView.setAdapter(new MyTeamAdapter(myTeamModel, R.layout.row, getActivity().getApplicationContext(), new OnTeamInfoClickListener() {
            @Override
            public void onItemClick(Team team) {
                String cid = team.getIdTeam();
                Fragment fr =new TeamInfoFrag();
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
