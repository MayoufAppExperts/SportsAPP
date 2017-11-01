package yalantis.com.sidemenu.sample.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import yalantis.com.sidemenu.sample.R;
import yalantis.com.sidemenu.sample.network.model.leaguePreResults.Event;
import yalantis.com.sidemenu.sample.network.model.leaguePreResults.LeaguesPrev;

/**
 * Created by TheAppExperts on 31/10/2017.
 */

public class LeaguePreResultsAdapter extends RecyclerView.Adapter <LeaguePreResultsAdapter.InfoViewHolder>{
    LeaguesPrev leaguesPrev;
    int live_score;
    Context applicationContext;

    public LeaguePreResultsAdapter(LeaguesPrev leaguesPrev, int live_score, Context applicationContext) {
        this.leaguesPrev = leaguesPrev;
        this.live_score = live_score;
        this.applicationContext = applicationContext;

    }

    @Override
    public InfoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(live_score, parent, false);
        return new InfoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(InfoViewHolder holder, int position) {
        Event prev = leaguesPrev.getEvents().get(position);
        holder.tvHomeTeam.setText(prev.getStrHomeTeam());
        holder.tvAwayTeam.setText(prev.getStrAwayTeam());
        holder.tvDate.setText(prev.getStrDate());
        //holder.tvHomeScore.setText(prev.getIntHomeScore());
        //holder.tvAwayScore.setText(prev.getIntAwayScore());
    }

    @Override
    public int getItemCount() {
        return leaguesPrev.getEvents().size();
    }

    public class InfoViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.homeTeam)
        TextView tvHomeTeam;
        @BindView(R.id.awayTeam)
        TextView tvAwayTeam;
        @BindView(R.id.fixDate)
        TextView tvDate;
       /* @BindView(R.id.homeScore)
        TextView tvHomeScore;
        @BindView(R.id.awayScore)
        TextView tvAwayScore;*/

        public InfoViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
