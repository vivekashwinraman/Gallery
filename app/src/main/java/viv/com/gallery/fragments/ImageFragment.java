package viv.com.gallery.fragments;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.List;

import viv.com.gallery.R;
import viv.com.gallery.adapters.ImageFragmentAdapter;
import viv.com.gallery.modelobjects.ImageObject;

import static android.content.ContentValues.TAG;

/**
 * Created by vraman on 6/16/17.
 */

public class ImageFragment extends DialogFragment {
    private RecyclerView imageRecyclerView;
    private ImageFragmentAdapter imageAdapter;
    private GridLayoutManager layoutManager;
    private String rootPath;
    private List<ImageObject> imageItemList = new ArrayList<ImageObject>();
    private static final String ROOT_PATH_TAG = "rootPath";

    public static ImageFragment newInstance(String rootPath) {
        ImageFragment imageFragment = new ImageFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ROOT_PATH_TAG, rootPath);
        imageFragment.setArguments(bundle);
        return imageFragment;
    }

    @Override
    public void onStart() {
        super.onStart();
        getDialog().getWindow()
                .setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dialog, container, false);
        layoutManager = new GridLayoutManager(getActivity(), 1);
        layoutManager.setOrientation(GridLayoutManager.HORIZONTAL);

        imageRecyclerView = (RecyclerView) view.findViewById(R.id.imageRecyclerView);
        imageRecyclerView.setLayoutManager(layoutManager);
        imageAdapter = new ImageFragmentAdapter(imageItemList, getActivity());
        imageRecyclerView.setAdapter(imageAdapter);
        imageRecyclerView.setItemAnimator(new DefaultItemAnimator());
        this.rootPath = getArguments().getString(ROOT_PATH_TAG);
        try {
            String[] assets = getActivity().getAssets().list(rootPath);
            for (String asset : assets) {
                imageItemList.add(new ImageObject(asset, rootPath + "/" + asset, asset));
                Log.v(TAG, asset);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return view;
    }
}