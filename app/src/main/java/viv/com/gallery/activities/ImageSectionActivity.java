package viv.com.gallery.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import viv.com.gallery.R;
import viv.com.gallery.adapters.BaseImageAdapter;
import viv.com.gallery.modelobjects.ImageObject;
import viv.com.gallery.uicontrols.BaseImageViewHolder;

public class ImageSectionActivity extends AppCompatActivity {

    private RecyclerView imageRecyclerView;
    private GridLayoutManager layoutManager;
    private BaseImageAdapter<BaseImageViewHolder> imageAdapter;
    private String rootPath;
    private List<ImageObject> imageItemList = new ArrayList<ImageObject>();
    private static final String TAG = "ImageSectionActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_section);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        layoutManager = new GridLayoutManager(this, 1);
        layoutManager.setOrientation(GridLayoutManager.VERTICAL);
        imageRecyclerView = (RecyclerView) findViewById(R.id.imageRecyclerView);
        imageRecyclerView.setLayoutManager(layoutManager);
        imageAdapter = new BaseImageAdapter<BaseImageViewHolder>(imageItemList, this);
        imageRecyclerView.setAdapter(imageAdapter);
        imageRecyclerView.setItemAnimator(new DefaultItemAnimator());
        rootPath =  getIntent().getStringExtra("image");
        try {
            String[] assets = getAssets().list(rootPath);
            for(String asset: assets){
                imageItemList.add(new ImageObject(asset, rootPath+"/"+asset, asset));
                Log.v(TAG, asset);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(this, MainActivity.class);
                NavUtils.navigateUpTo(this, intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
