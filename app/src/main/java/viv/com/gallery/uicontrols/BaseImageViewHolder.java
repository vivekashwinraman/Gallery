package viv.com.gallery.uicontrols;

/**
 * Created by vraman on 6/15/17.
 */


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import viv.com.gallery.R;

public class BaseImageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
    public ImageView imgViewIcon;
    public TextView title;

    public BaseImageViewHolder(View itemLayoutView) {
        super(itemLayoutView);
        imgViewIcon = (ImageView) itemLayoutView.findViewById(R.id.item_icon);
        title = (TextView) itemLayoutView.findViewById(R.id.title);
        itemLayoutView.setOnClickListener(this);
        itemLayoutView.setOnLongClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public boolean onLongClick(View view) {
        return false;
    }

}
