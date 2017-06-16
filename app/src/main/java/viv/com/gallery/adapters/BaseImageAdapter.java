package viv.com.gallery.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import viv.com.gallery.R;
import viv.com.gallery.managers.ImageManager;
import viv.com.gallery.modelobjects.ImageObject;
import viv.com.gallery.uicontrols.BaseImageViewHolder;

/**
 * Created by vraman on 6/15/17.
 */

public class BaseImageAdapter<I extends BaseImageViewHolder> extends RecyclerView.Adapter<BaseImageViewHolder> {
    protected List<ImageObject> imageObjects;
    protected Context context;
    protected ImageManager imageManager;

    public BaseImageAdapter(List<ImageObject> imageObjects, Context context) {
        this.imageObjects = imageObjects;
        this.context = context;
        imageManager = new ImageManager(context);
    }

    @Override
    public BaseImageViewHolder onCreateViewHolder(ViewGroup parent,
                                                  int viewType) {
        View itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.image_item_base, parent, false);
        BaseImageViewHolder baseImageViewHolder = new BaseImageViewHolder(itemLayoutView);
        return baseImageViewHolder;
    }

    @Override
    public void onBindViewHolder(BaseImageViewHolder baseImageViewHolder, int position) {
        ImageObject imageObject = imageObjects.get(position);
        if (imageObject != null) {
            baseImageViewHolder.title.setText(imageObject.getTitle());
            final Bitmap bitmap = imageManager.getBitmapFromCache(imageObject.getImageUri());
            if (bitmap == null) {
                baseImageViewHolder.imgViewIcon.setImageResource(R.mipmap.ic_launcher);
                imageManager.loadImage(baseImageViewHolder.imgViewIcon, imageObject.getImageUri());
            } else {
                baseImageViewHolder.imgViewIcon.setImageBitmap(bitmap);
            }
        }
    }

    @Override
    public int getItemCount() {
        return imageObjects.size();
    }
}
