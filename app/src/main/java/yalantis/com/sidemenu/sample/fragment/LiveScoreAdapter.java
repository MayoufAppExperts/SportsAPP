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
    int row;
    Context applicationContext;

    public LiveScoreAdapter(LiveScores liveScores, int row, Context applicationContext) {
        this.liveScores = liveScores;
        this.row = row;
        this.applicationContext = applicationContext;
    }

    @Override
    public LiveScoreHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.i("Adapter", "Live Scores");
        View view = LayoutInflater.from(parent.getContext()).inflate(row, null);
        return new LiveScoreHolder(view);
    }

    @Override
    public void onBindViewHolder(LiveScoreHolder holder, int position) {
        if (liveScores.getTeams().getMatch() != null) {
            holder.tvName.setText(liveScores.getTeams().getMatch().get(position).getHomeTeam());
        } else {
            holder.tvName.setText("No matches");
        }

    }

    @Override
    public int getItemCount() {
        //Log.i("Array size", String.valueOf(liveScores.getTeams().getMatch().size()));
        int size = 0;
        if (liveScores.getTeams().getMatch() != null) {
            size = liveScores.getTeams().getMatch().size();
        }
        else {
            size = 1;
        }
        return size;
    }

    public class LiveScoreHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.clubName)
        TextView tvName;

        public LiveScoreHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
