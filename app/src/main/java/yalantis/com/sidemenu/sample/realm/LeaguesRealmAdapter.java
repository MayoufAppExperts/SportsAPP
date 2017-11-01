package yalantis.com.sidemenu.sample.realm;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import yalantis.com.sidemenu.sample.R;


public class LeaguesRealmAdapter extends RecyclerView.Adapter<LeaguesRealmAdapter.MyViewHolder> {

    ArrayList<FootballModelRealm> footballModelRealms;
    int row;
    Context applicationContext;

    public LeaguesRealmAdapter(ArrayList<FootballModelRealm> footballModelRealms, int row, Context applicationContext) {
        this.footballModelRealms = footballModelRealms;
        this.row = row;
        this.applicationContext = applicationContext;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(row, parent, false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        CountryRealm countryRealm  = footballModelRealms.get(position).getCountrys().get(position);
        holder.name.setText(countryRealm.getStrLeague());

    }

    @Override
    public int getItemCount() {
        return footballModelRealms.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.clubName)
        TextView name;
        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
