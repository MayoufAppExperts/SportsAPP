package yalantis.com.sidemenu.sample.fragment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import yalantis.com.sidemenu.sample.R;
import yalantis.com.sidemenu.sample.network.model.livescores.LiveScores;


class LiveScoreAdapter extends RecyclerView.Adapter<LiveScoreAdapter.LiveScoreHolder> {

    LiveScores liveScores;
    int live_score;
    Context applicationContext;

    public LiveScoreAdapter(LiveScores liveScores, int live_score, Context applicationContext) {
        this.liveScores = liveScores;
        this.live_score = live_score;
        this.applicationContext = applicationContext;
    }

    @Override
    public LiveScoreHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.i("scoread", "Live Scores");
        View view = LayoutInflater.from(parent.getContext()).inflate(live_score, parent, false);
        return new LiveScoreHolder(view);
    }

    @Override
    public void onBindViewHolder(LiveScoreHolder holder, int position) {
        //Log.i("onbindscore", "loaded");
        holder.tvName.setText(liveScores.getTeams().getMatch().get(0).getHomeTeam());
    }

    @Override
    public int getItemCount() {
        return 1;
        //return liveScores.getTeams().getMatch().size();
    }

    public class LiveScoreHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.homeTeam)
        TextView tvName;

        public LiveScoreHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
