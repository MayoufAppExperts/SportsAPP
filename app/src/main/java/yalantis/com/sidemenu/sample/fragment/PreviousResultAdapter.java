package yalantis.com.sidemenu.sample.fragment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;
import yalantis.com.sidemenu.sample.R;
import yalantis.com.sidemenu.sample.network.model.previousModel.PreviousFixtures;
import yalantis.com.sidemenu.sample.network.model.previousModel.Result;

/**
 * Created by TheAppExperts on 25/10/2017.
 */

class PreviousResultAdapter extends RecyclerView.Adapter<PreviousResultAdapter.PreViewHolder> {

    PreviousFixtures previousFixtures;
    int live_score;
    Context applicationContext;

    public PreviousResultAdapter(PreviousFixtures previousFixtures, int live_score, Context applicationContext) {
        this.previousFixtures = previousFixtures;
        this.live_score = live_score;
        this.applicationContext = applicationContext;
    }

    @Override
    public PreViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(live_score, parent, false);
        return new PreViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PreViewHolder holder, int position) {
        Result prev = previousFixtures.getResults().get(position);
        holder.tvHomeTeam.setText(prev.getStrHomeTeam());
        holder.tvAwayTeam.setText(prev.getStrAwayTeam());
        holder.tvHomeScore.setText(prev.getIntHomeScore());
        holder.tvAwayScore.setText(prev.getIntAwayScore());
    }

    @Override
    public int getItemCount() {
        //Log.i("Previous Fixture count", String.valueOf(previousFixtures.getResults().size()));
        return previousFixtures.getResults().size();
    }

    public class PreViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.homeTeam)
        TextView tvHomeTeam;
        @BindView(R.id.awayTeam)
        TextView tvAwayTeam;
        @BindView(R.id.homeScore)
        TextView tvHomeScore;
        @BindView(R.id.awayScore)
        TextView tvAwayScore;

        public PreViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
