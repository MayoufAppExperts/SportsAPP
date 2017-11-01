package yalantis.com.sidemenu.sample.fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.res.ResourcesCompat;
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
import me.piruin.quickaction.ActionItem;
import me.piruin.quickaction.QuickAction;
import yalantis.com.sidemenu.sample.R;
import yalantis.com.sidemenu.sample.network.model.Country;
import yalantis.com.sidemenu.sample.network.model.FootballModel;
import yalantis.com.sidemenu.sample.network.service.OnItemClickListener;
import yalantis.com.sidemenu.sample.sdi.component.IActivityComponent;
import yalantis.com.sidemenu.sample.ui.base.BaseFragment;
import yalantis.com.sidemenu.sample.ui.leagues.ILeaguesMvpView;
import yalantis.com.sidemenu.sample.ui.leagues.LeaguesPresenter;

//import yalantis.com.sidemenu.sample.realm.RealmController;
//import yalantis.com.sidemenu.sample.sdi.component.DaggerIActivityComponent;


public class LeaguesFrag extends BaseFragment implements ILeaguesMvpView {


    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @BindView(R.id.swipeRefresh)
    SwipeRefreshLayout mySwipeRefreshLayout;

    IActivityComponent iActivityComponent;


    private static final int ID_UP = 1;
    private static final int ID_DOWN = 2;
    private static final int ID_SEARCH = 3;
    private static final int ID_INFO = 4;

    private QuickAction quickAction;

//    Realm realm;
//    RealmController realmController;


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
        //initialiseRealm();
        initialiseRecyclerView(view);
        initialiseDagger();
        quickActionInitialise();
        isNetworkConnected();

        viewLeaguesPresenter.onAttach(this);
        viewLeaguesPresenter.onViewPrepared();


        super.onViewCreated(view, savedInstanceState);
    }

/*    private void initialiseRealm() {
        Realm.init(getActivity().getApplicationContext());
        realm=Realm.getDefaultInstance();
        realmController=new RealmController(realm);
    }*/
/*
    public boolean isNetworkConnected(){
        ConnectivityManager connectivityManager = (ConnectivityManager)getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        return false;

    }*/

    private void quickActionInitialise() {
        QuickAction.setDefaultColor(ResourcesCompat.getColor(getResources(), R.color.colorAccent, null));
        QuickAction.setDefaultTextColor(Color.BLACK);

        ActionItem nextItem = new ActionItem(ID_DOWN, "Teams", R.drawable.icn_1);
        ActionItem prevItem = new ActionItem(ID_UP, "League Info", R.drawable.icn_2);
        ActionItem fixturesItem = new ActionItem(ID_SEARCH, "Fixtures", R.drawable.icn_3);
        ActionItem upcomingItem = new ActionItem(ID_INFO, "Results", R.drawable.icn_4);
        prevItem.setSticky(true);
        nextItem.setSticky(true);
        fixturesItem.setSticky(true);
        upcomingItem.setSticky(true);

        quickAction = new QuickAction(getContext(), QuickAction.HORIZONTAL);
        quickAction.setColorRes(R.color.colorPrimary);
        quickAction.setTextColorRes(R.color.cardview_light_background);

        quickAction.addActionItem(nextItem, prevItem, fixturesItem, upcomingItem);
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
        //recyclerView.setAdapter(new CakeAdapter(customerModels, R.layout.row, getActivity()));
    }

    @Override
    public void onFetchLeagueCompleted(final FootballModel footballModel) {
        recyclerView.setAdapter(new FootballAdapter(footballModel, R.layout.row, getActivity().getApplicationContext(), new OnItemClickListener() {
            @Override
            public void onItemClick(View view, Country country) {
                quickAction.show(view);
                quickAction.setOnActionItemClickListener(new QuickAction.OnActionItemClickListener() {
                    @Override
                    public void onItemClick(ActionItem item) {
                        String title = item.getTitle();
                        if (title == "Teams") {
                            String cid = country.getIdLeague();
                            Fragment fr = new TeamsInLeaguesFrag();
                            FragmentManager fm = getFragmentManager();
                            FragmentTransaction ft = fm.beginTransaction();
                            Bundle args = new Bundle();
                            args.putString("id", cid);
                            fr.setArguments(args);
                            ft.replace(R.id.content_frame, fr);
                            ft.commit();
                            quickAction.dismiss();
                        }else if (title == "League Info"){
                            String cid = country.getIdLeague();
                            Fragment fr = new LeagueInfoFrag();
                            FragmentManager fm = getFragmentManager();
                            FragmentTransaction ft = fm.beginTransaction();
                            Bundle args = new Bundle();
                            args.putString("id", cid);
                            fr.setArguments(args);
                            ft.replace(R.id.content_frame, fr);
                            ft.commit();
                            quickAction.dismiss();

                        }else if (title == "Fixtures"){
                            String cid = country.getIdLeague();
                            Fragment fr = new LeaguePreResultsFrag();
                            FragmentManager fm = getFragmentManager();
                            FragmentTransaction ft = fm.beginTransaction();
                            Bundle args = new Bundle();
                            args.putString("id", cid);
                            fr.setArguments(args);
                            ft.replace(R.id.content_frame, fr);
                            ft.commit();
                            quickAction.dismiss();
                        }else if (title == "Results"){
                            String cid = country.getIdLeague();
                            Fragment fr = new NextLeagueFixFrag();
                            FragmentManager fm = getFragmentManager();
                            FragmentTransaction ft = fm.beginTransaction();
                            Bundle args = new Bundle();
                            args.putString("id", cid);
                            fr.setArguments(args);
                            ft.replace(R.id.content_frame, fr);
                            ft.commit();
                            quickAction.dismiss();
                        }
                        else {
                            Toast.makeText(getActivity(), title + " selected", Toast.LENGTH_SHORT).show();
                            // if (!item.isSticky()) quickAction.remove(item);
                        }
                    }
                });
            }
        }));
        Log.i("Fetch", "Completed");
    }
}
