package yalantis.com.sidemenu.sample.fragment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import yalantis.com.sidemenu.sample.R;
import yalantis.com.sidemenu.sample.network.model.MyTeamModel;

/**
 * Created by TheAppExperts on 23/10/2017.
 */

class TeamInfoAdapter extends RecyclerView.Adapter<TeamInfoAdapter.InfoViewHolder> {

    MyTeamModel myTeamModel;
    int row;
    Context applicationContext;

    public TeamInfoAdapter(MyTeamModel myTeamModel, int row, Context applicationContext) {
        this.myTeamModel = myTeamModel;
        this.row = row;
        this.applicationContext = applicationContext;

    }

    @Override
    public InfoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(row, null);
        return new InfoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(InfoViewHolder holder, int position) {

        holder.tvName.setText(myTeamModel.getTeams().get(position).getStrTeam());
        Picasso.with(applicationContext)
                .load(myTeamModel.getTeams().get(position).getStrTeamBadge())
                .resize(500,250)
                .into(holder.imgLogo);
    }

    @Override
    public int getItemCount() {
        return myTeamModel.getTeams().size();
    }

    public class InfoViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.clubName)TextView tvName;
        @BindView(R.id.imageView) ImageView imgLogo;


        public InfoViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
