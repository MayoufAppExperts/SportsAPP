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
import yalantis.com.sidemenu.sample.MyApp;
import yalantis.com.sidemenu.sample.R;
import yalantis.com.sidemenu.sample.network.model.previousModel.PreviousFixtures;
import yalantis.com.sidemenu.sample.sdi.component.DaggerIActivityComponent;
import yalantis.com.sidemenu.sample.sdi.component.IActivityComponent;
import yalantis.com.sidemenu.sample.sdi.module.ActivityModule;
import yalantis.com.sidemenu.sample.ui.base.BaseFragment;
import yalantis.com.sidemenu.sample.ui.leagues.ILeaguesMvpView;
import yalantis.com.sidemenu.sample.ui.previousScores.IPreviousResultMvpView;
import yalantis.com.sidemenu.sample.ui.previousScores.PreviousResultPresenter;

import static yalantis.com.sidemenu.sample.MyApp.getApplication;

/**
 * Created by TheAppExperts on 25/10/2017.
 */

public class PreviousResultFrag extends BaseFragment implements IPreviousResultMvpView {


    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    IActivityComponent iActivityComponent;

    public IActivityComponent getiActivityComponent() {
        return iActivityComponent;
    }


    @Inject
    PreviousResultPresenter<IPreviousResultMvpView> previousResultPresenter;



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

        String id = getArguments().getString("id");
        String img = getArguments().getString("img");


        previousResultPresenter.onAttach(this);
        previousResultPresenter.onViewPrepared(id);

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
        //recyclerView.setAdapter(new CakeAdapter(customerModels, R.layout.row, getActivity()));
    }

    @Override
    public void onError(String message) {
        Log.i("Error Previous", message);
        //super.onError(message);
    }

    @Override
    public void onFetchPreviousResult(PreviousFixtures previousFixtures) {
        recyclerView.setAdapter(new PreviousResultAdapter(previousFixtures, R.layout.live_score, getActivity().getApplicationContext()));

    }
}
