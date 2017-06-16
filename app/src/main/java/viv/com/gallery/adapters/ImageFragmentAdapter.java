package viv.com.gallery.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import viv.com.gallery.R;
import viv.com.gallery.modelobjects.ImageObject;
import viv.com.gallery.uicontrols.BaseImageViewHolder;

/**
 * Created by vraman on 6/16/17.
 */

public class ImageFragmentAdapter extends BaseImageAdapter<BaseImageViewHolder> {
    public ImageFragmentAdapter(List<ImageObject> imageObjects, Context context) {
        super(imageObjects, context);
    }

    @Override
    public BaseImageViewHolder onCreateViewHolder(ViewGroup parent,
                                                  int viewType) {
        View itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.image_item, parent, false);
        BaseImageViewHolder viewHolder = new BaseImageViewHolder(itemLayoutView);
        viewHolder.title.setVisibility(View.GONE);
        return viewHolder;
    }
}
