package yalantis.com.sidemenu.sample.fragment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import yalantis.com.sidemenu.sample.R;
import yalantis.com.sidemenu.sample.network.model.upcomingEvents.Event;
import yalantis.com.sidemenu.sample.network.model.upcomingEvents.UpcomingEvents;

/**
 * Created by TheAppExperts on 26/10/2017.
 */

public class UpcomingEventsAdapter extends RecyclerView.Adapter<UpcomingEventsAdapter.UpViewHolder> {

    UpcomingEvents upcomingEvents;
    int live_score;
    Context applicationContext;

    public UpcomingEventsAdapter(UpcomingEvents upcomingEvents, int live_score, Context applicationContext) {
        this.upcomingEvents = upcomingEvents;
        this.live_score = live_score;
        this.applicationContext = applicationContext;

    }

    @Override
    public UpViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(live_score, parent, false);
        return new UpViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UpViewHolder holder, int position) {
        Event event = upcomingEvents.getEvents().get(position);
        holder.tvHomeTeam.setText(event.getStrHomeTeam());
        holder.tvAwayTeam.setText(event.getStrAwayTeam());

    }

    @Override
    public int getItemCount() {
        return upcomingEvents.getEvents().size();
    }

    public class UpViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.homeTeam)
        TextView tvHomeTeam;
        @BindView(R.id.awayTeam)
        TextView tvAwayTeam;

        public UpViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
