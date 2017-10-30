package yalantis.com.sidemenu.sample.network.service;


import android.view.View;

import yalantis.com.sidemenu.sample.fragment.FootballAdapter;
import yalantis.com.sidemenu.sample.network.model.Country;

public interface OnItemClickListener {

    void onItemClick(View view , Country country);
}
