package viv.com.gallery.adapters;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import viv.com.gallery.R;
import viv.com.gallery.activities.ImageSectionActivity;
import viv.com.gallery.fragments.ImageFragment;
import viv.com.gallery.modelobjects.ImageObject;
import viv.com.gallery.uicontrols.BaseImageViewHolder;

/**
 * Created by vraman on 6/15/17.
 */

public class ImageAdapter extends BaseImageAdapter<ImageAdapter.ImageViewHolder> {
    public ImageAdapter(List<ImageObject> imageObjects, Context context) {
        super(imageObjects, context);
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent,
                                              int viewType) {
        View itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.image_item, parent, false);
        ImageViewHolder viewHolder = new ImageViewHolder(itemLayoutView);
        return viewHolder;
    }

    public class ImageViewHolder extends BaseImageViewHolder {

        public ImageViewHolder(View itemLayoutView) {
            super(itemLayoutView);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, ImageSectionActivity.class);
            Bundle mBundle = new Bundle();
            ImageObject imageObject = imageObjects.get(getAdapterPosition());
            mBundle.putString("image", imageObject.getRootPath());
            intent.putExtras(mBundle);
            context.startActivity(intent);
        }

        @Override
        public boolean onLongClick(View view) {
            ImageObject imageObject = imageObjects.get(getAdapterPosition());
            DialogFragment fragment = ImageFragment.newInstance(imageObject.getRootPath());
            FragmentManager manager = ((Activity) context).getFragmentManager();
            fragment.show(manager, imageObject.getRootPath());
            return false;
        }

    }
}
