package yalantis.com.sidemenu.sample.fragment;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import yalantis.com.sidemenu.sample.R;

/**
 * Created by Konstantin on 22.12.2014.
 */
public class ContentFragment extends Fragment {
    public static final String CLOSE = "Close";
    public static final String BUILDING = "Building";
    public static final String BOOK = "Book";
    public static final String PAINT = "Paint";
    public static final String CASE = "Case";
    public static final String SHOP = "Shop";
    public static final String PARTY = "Party";
    public static final String MOVIE = "Movie";

    private View containerView;
    protected ImageView mImageView;
    protected int res;
    private Bitmap bitmap;
    TextView textView;

    @BindView(R.id.swipeRefresh)
    SwipeRefreshLayout mySwipeRefreshLayout;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        //this.containerView = view.findViewById(R.id.container);
        ButterKnife.bind(this, view);
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        //mImageView = (ImageView) rootView.findViewById(R.id.image_content);
//        mImageView.setClickable(true);
//        mImageView.setFocusable(true);
//        mImageView.setImageResource(res);
        return rootView;
    }


    private void swipeRefresh(View view) {

        //mySwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefresh);
        mySwipeRefreshLayout.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        refreshItems();
                        Toast.makeText(getActivity().getApplicationContext(), "Refreshed", Toast.LENGTH_LONG);
                        myUpdateOperation();
                        initialiseRecyclerView(view);
                    }

                    public void myUpdateOperation() {

                        mySwipeRefreshLayout.setRefreshing(true);
                    }
                });
    }

    private void refreshItems() {

    }

    private void initialiseRecyclerView(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext().getApplicationContext(), 2));
        Log.d("Recycler View", "Initialised True");
    }
}


