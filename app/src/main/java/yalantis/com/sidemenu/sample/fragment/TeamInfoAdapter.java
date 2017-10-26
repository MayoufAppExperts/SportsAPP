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
import yalantis.com.sidemenu.sample.network.model.myteam.MyTeamModel;
import yalantis.com.sidemenu.sample.network.model.myteam.Team;
import yalantis.com.sidemenu.sample.network.model.previousModel.Result;
import yalantis.com.sidemenu.sample.network.service.OnPreviousFixtureClickListener;


class TeamInfoAdapter extends RecyclerView.Adapter<TeamInfoAdapter.InfoViewHolder> {

    MyTeamModel myTeamModel;
    int team_info;
    Context applicationContext;
    OnPreviousFixtureClickListener listener;
    Result result;

    public TeamInfoAdapter(MyTeamModel myTeamModel, int team_info, Context applicationContext, OnPreviousFixtureClickListener listener) {
        this.myTeamModel = myTeamModel;
        this.team_info = team_info;
        this.applicationContext = applicationContext;
        this.listener = listener;

    }

    @Override
    public InfoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(team_info, null);
        return new InfoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(InfoViewHolder holder, int position) {

        String fillVoid = "Unavailable";

        Team team = myTeamModel.getTeams().get(position);
        holder.tvName.setText(team.getStrTeam());
        holder.tvAltName.setText(team.getStrAlternate());

       /* if (team.getIntFormedYear() == null) {
            holder.tvYearFormed.setText(fillVoid);
        } else {
            holder.tvYearFormed.setText(team.getIntFormedYear());
        }*/

        holder.tvYearFormed.setText(
                (team.getIntFormedYear() == null) ?
                        fillVoid :
                        team.getIntFormedYear()
        );

        if (team.getStrManager() == null) {
            holder.tvManager.setText(fillVoid);
        } else {
            holder.tvManager.setText(team.getStrManager());
        }

        if (team.getStrStadium() == null) {
            holder.tvStadium.setText(fillVoid);
        } else {
            holder.tvStadium.setText(team.getStrStadium());
        }

        if (team.getIntStadiumCapacity() == "0") {
            holder.tvStadiumCapacity.setText(fillVoid);
        } else {
            holder.tvStadiumCapacity.setText(team.getIntStadiumCapacity());
        }

        if (team.getStrStadiumLocation() == null) {
            holder.tvStadium.setText(fillVoid);
        } else {
            holder.tvLocation.setText(team.getStrStadiumLocation());
        }


        holder.tvCountry.setText(team.getStrCountry());

        if (team.getStrDescriptionEN() != null) {
            holder.tvDescr.setText(team.getStrDescriptionEN());
        } else if (team.getStrDescriptionFR() != null) {
            holder.tvDescr.setText(team.getStrDescriptionFR().toString());
        } else if (team.getStrDescriptionDE() != null) {
            holder.tvDescr.setText(team.getStrDescriptionDE());
        } else if (team.getStrDescriptionES() != null) {
            holder.tvDescr.setText(team.getStrDescriptionES().toString());
        } else if (team.getStrDescriptionIT() != null) {
            holder.tvDescr.setText(team.getStrDescriptionIT());
        } else if (team.getStrDescriptionRU() != null) {
            holder.tvDescr.setText(team.getStrDescriptionRU().toString());
        } else if (team.getStrDescriptionJP() != null) {
            holder.tvDescr.setText(team.getStrDescriptionJP().toString());
        } else if (team.getStrDescriptionPT() != null) {
            holder.tvDescr.setText(team.getStrDescriptionPT().toString());
        } else if (team.getStrDescriptionSE() != null) {
            holder.tvDescr.setText(team.getStrDescriptionSE().toString());
        } else if (team.getStrDescriptionNL() != null) {
            holder.tvDescr.setText(team.getStrDescriptionNL().toString());
        } else if (team.getStrDescriptionIL() != null) {
            holder.tvDescr.setText(team.getStrDescriptionIL().toString());
        } else if (team.getStrDescriptionPL() != null) {
            holder.tvDescr.setText(team.getStrDescriptionPL().toString());
        } else {
            holder.tvDescr.setText("DESCRIPTION UNAVAILABLE");
        }

        Picasso.with(applicationContext)
                .load(myTeamModel.getTeams().get(position).getStrTeamBadge())
                .resize(500, 500)
                .into(holder.imgLogo);

        holder.bind(team, listener);
    }

    @Override
    public int getItemCount() {
        return myTeamModel.getTeams().size();
    }

    public class InfoViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.teamName)
        TextView tvName;
        @BindView(R.id.homeImage)
        ImageView imgLogo;
        @BindView(R.id.altName)
        TextView tvAltName;
        @BindView(R.id.yearFormed)
        TextView tvYearFormed;
        @BindView(R.id.manager)
        TextView tvManager;
        @BindView(R.id.stadiumName)
        TextView tvStadium;
        @BindView(R.id.seatCapacity)
        TextView tvStadiumCapacity;
        @BindView(R.id.stadiumLocation)
        TextView tvLocation;
        @BindView(R.id.teamCountry)
        TextView tvCountry;
        @BindView(R.id.clubDescr)
        TextView tvDescr;
        @BindView(R.id.preButton)
        Button btnPre;


        public InfoViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(final Team team, final OnPreviousFixtureClickListener listener) {
            btnPre.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(team);
                }
            });
        }
    }
}
