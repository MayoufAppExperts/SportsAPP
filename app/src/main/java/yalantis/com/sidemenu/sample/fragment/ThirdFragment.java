package yalantis.com.sidemenu.sample.fragment;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import yalantis.com.sidemenu.sample.R;

/**
 * Created by TheAppExperts on 20/10/2017.
 */

public class ThirdFragment extends Fragment {

    protected int res;
    TextView textView;


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Log.d("Third Fragment", "onviewcreated");
        //this.containerView = view.findViewById(R.id.container);
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        Log.d("Third Fragment", "oncreateview");
        return rootView;

    }
}
