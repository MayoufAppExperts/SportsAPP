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
import yalantis.com.sidemenu.sample.network.model.myteam.MyTeamModel;
import yalantis.com.sidemenu.sample.network.model.myteam.Team;
import yalantis.com.sidemenu.sample.network.service.OnTeamInfoClickListener;

/**
 * Created by TheAppExperts on 19/10/2017.
 */

class MyTeamAdapter extends RecyclerView.Adapter<MyTeamAdapter.MyTeamViewHolder> {

    MyTeamModel myTeamModel;
    int row;
    Context context;
    OnTeamInfoClickListener onItemClickListener;

    public MyTeamAdapter(MyTeamModel myTeamModel, int row, Context context, OnTeamInfoClickListener onItemClickListener) {
        this.myTeamModel = myTeamModel;
        this.row = row;
        this.context = context;
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public MyTeamViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(row, parent, false);
        return new MyTeamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyTeamViewHolder holder, int position) {
        holder.tvName.setText(myTeamModel.getTeams().get(position).getStrTeam());

        Picasso.with(context)
                .load(myTeamModel.getTeams().get(position).getStrTeamBadge())
                .resize(250, 250)
                .into(holder.imgLogo);


        holder.bind(myTeamModel.getTeams().get(position), onItemClickListener);

    }

    @Override
    public int getItemCount() {
        return myTeamModel.getTeams().size();
    }

    public class MyTeamViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.clubName)
        TextView tvName;
        @BindView(R.id.imageView)
        ImageView imgLogo;

        public MyTeamViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

        public void bind(final Team team, final OnTeamInfoClickListener onItemClickListener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickListener.onItemClick(team);
                }
            });
        }
    }
}
