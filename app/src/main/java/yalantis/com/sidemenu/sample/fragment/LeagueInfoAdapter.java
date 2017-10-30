package yalantis.com.sidemenu.sample.fragment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import yalantis.com.sidemenu.sample.R;
import yalantis.com.sidemenu.sample.network.model.leagueInfo.League;
import yalantis.com.sidemenu.sample.network.model.leagueInfo.LeagueInfo;

/**
 * Created by TheAppExperts on 30/10/2017.
 */

class LeagueInfoAdapter extends RecyclerView.Adapter <LeagueInfoAdapter.InfoViewHolder>{


    LeagueInfo leagueInfo;
    int team_info;
    Context applicationContext;

    public LeagueInfoAdapter(LeagueInfo leagueInfo, int team_info, Context applicationContext) {
        this.leagueInfo = leagueInfo;
        this.team_info = team_info;
        this.applicationContext = applicationContext;
    }

    @Override
    public InfoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(team_info, parent, false);
        return new InfoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(InfoViewHolder holder, int position) {

        League check  = leagueInfo.getLeagues().get(position);

        holder.tvName.setText(check.getStrLeague());
        holder.tvCountry.setText(check.getStrCountry());
        holder.tvYearFormed.setText(check.getIntFormedYear());
        holder.tvDescr.setText(check.getStrDescriptionEN());

        Picasso.with(applicationContext)
                .load(check.getStrBadge())
                .resize(500, 500)
                .into(holder.imgLogo);

    }

    @Override
    public int getItemCount() {
        return leagueInfo.getLeagues().size();
    }

    public class InfoViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.teamName)
        TextView tvName;
        @BindView(R.id.homeImage)
        ImageView imgLogo;
        @BindView(R.id.yearFormed)
        TextView tvYearFormed;
        @BindView(R.id.teamCountry)
        TextView tvCountry;
        @BindView(R.id.clubDescr)
        TextView tvDescr;
        @BindView(R.id.preButton)
        Button btnPre;
        @BindView(R.id.upComingButton)
        Button btnNext;


        public InfoViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            btnPre.setVisibility(View.INVISIBLE);
            btnNext.setVisibility(View.INVISIBLE);
        }
    }
}
