package yalantis.com.sidemenu.sample.fragment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import yalantis.com.sidemenu.sample.R;
import yalantis.com.sidemenu.sample.network.model.Country;
import yalantis.com.sidemenu.sample.network.model.FootballModel;
import yalantis.com.sidemenu.sample.network.service.OnItemClickListener;

/**
 * Created by TheAppExperts on 18/10/2017.
 */

class FootballAdapter extends RecyclerView.Adapter<FootballAdapter.FootballViewHolder> {

    FootballModel footballModel;
    int row;
    Context context;
    OnItemClickListener onItemClickListener;

    public FootballAdapter(FootballModel footballModel, int row, Context context, OnItemClickListener onItemClickListener) {
        this.footballModel = footballModel;
        this.row = row;
        this.context = context;
        this.onItemClickListener = onItemClickListener;

    }

    @Override
    public FootballViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view  = LayoutInflater.from(parent.getContext()).inflate(row, parent, false);
        return new FootballViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FootballViewHolder holder, int position) {
        holder.tvClub.setText(footballModel.getCountrys().get(position).getStrLeague());

        Picasso.with(context)
                .load(footballModel.getCountrys().get(position).getStrLogo())
                .resize(500,250)
                .into(holder.imgLogo);

        holder.bind(footballModel.getCountrys().get(position), onItemClickListener);
    }

    @Override
    public int getItemCount() {

        return footballModel.getCountrys().size();
    }

    public class FootballViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.clubName)
        TextView tvClub;
        @BindView(R.id.imageView)
        ImageView imgLogo;

        public FootballViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }

        public void bind(final Country country, final OnItemClickListener onItemClickListener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickListener.onItemClick(country);
                }
            });
        }
    }
}
