package yalantis.com.sidemenu.sample.fragment;

import android.app.DatePickerDialog;
import android.app.SearchManager;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Locale;

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
import yalantis.com.sidemenu.sample.ui.dayEvents.DayEventPresenter;
import yalantis.com.sidemenu.sample.ui.dayEvents.IDayEventMvpView;

import static yalantis.com.sidemenu.sample.MyApp.getApplication;

/**
 * Created by TheAppExperts on 31/10/2017.
 */

public class DayEventFrag extends BaseFragment implements IDayEventMvpView {


    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @BindView(R.id.swipeRefresh)
    SwipeRefreshLayout mySwipeRefreshLayout;

    @BindView(R.id.dateBtn)
    Button btnDate;
    @BindView(R.id.txtDate)
    TextView tvDate;

    IActivityComponent iActivityComponent;
    String d = "";
    Calendar myCalendar = Calendar.getInstance();
    public IActivityComponent getiActivityComponent() {
        return iActivityComponent;
    }

    @Inject
    DayEventPresenter<IDayEventMvpView> dayEventPresenter;

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
        //id = getArguments().getString("id");
        btnDate.setVisibility(View.VISIBLE);
        tvDate.setVisibility(View.VISIBLE);

        d = "2017-10-11";
        dayEventPresenter.onAttach(this);
        dayEventPresenter.onViewPrepared(d);

        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, month);
                myCalendar.set(Calendar.DAY_OF_MONTH, day);
                updateLabel();

            }
        };
        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(getContext(), date,
                        myCalendar.get(Calendar.YEAR),
                        myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();

            }
        });

        super.onViewCreated(view, savedInstanceState);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void updateLabel() {
        String myFormat = "yyyy-MM-dd"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.UK);

        tvDate.setText(sdf.format(myCalendar.getTime()));
        d = sdf.format(myCalendar.getTime());
        Log.i("dcheck", "" + d);
        dayEventPresenter.onViewPrepared(d);
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
    public void onFetchDayEventCompleted(LeaguesPrev leaguesPrev) {
        recyclerView.setAdapter(new LeaguePreResultsAdapter(leaguesPrev, R.layout.live_score, getActivity().getApplicationContext(), new OnDayEventClickListener() {
            @Override
            public void onItemClick(View view, Event event) {
                Toast.makeText(getContext(), "CLICKED!", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MediaStore.INTENT_ACTION_MEDIA_PLAY_FROM_SEARCH);
                intent.putExtra(SearchManager.QUERY, event.getStrEvent() + " " + event.getStrDate());
                intent.setPackage("com.google.android.youtube");
                startActivity(intent);

            }
        }));
    }

    @Override
    public void onError(String message) {
        Log.i("errorDay", message);
    }
}
