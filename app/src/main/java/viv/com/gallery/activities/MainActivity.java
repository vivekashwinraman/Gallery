package viv.com.gallery.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import viv.com.gallery.R;
import viv.com.gallery.adapters.ImageAdapter;
import viv.com.gallery.modelobjects.ImageObject;

public class MainActivity extends Activity {

    private RecyclerView imageRecyclerView;
    private GridLayoutManager layoutManager;
    private ImageAdapter imageAdapter;
    private List<ImageObject> imageItemList = new ArrayList<ImageObject>();
    private static final String TAG = "MainActivity";
    private List<String> folders = new ArrayList<>();
    private static final String FIRST_JPG = "/1.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        folders.add("Animals");
        folders.add("Architecture");
        folders.add("Food");
        folders.add("Posters");
        folders.add( "Scenery");

        layoutManager = new GridLayoutManager(this, 1);
        layoutManager.setOrientation(GridLayoutManager.VERTICAL);
        imageRecyclerView = (RecyclerView) findViewById(R.id.imageRecyclerView);
        imageRecyclerView.setLayoutManager(layoutManager);
        imageAdapter = new ImageAdapter(imageItemList, this);
        imageRecyclerView.setAdapter(imageAdapter);
        imageRecyclerView.setItemAnimator(new DefaultItemAnimator());
        try {
            String[] assets = getAssets().list("");
            for(String asset: assets){
                if(folders.contains(asset)) {
                    imageItemList.add(new ImageObject(asset, asset + FIRST_JPG, asset));
                    Log.v(TAG, asset);
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
