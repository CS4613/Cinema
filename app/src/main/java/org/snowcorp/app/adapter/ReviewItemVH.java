package org.snowcorp.app.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.snowcorp.app.R;


public class ReviewItemVH extends ReviewVH {
    TextView txtContent;
    TextView txtAuthor;

    public ReviewItemVH(final View itemView) {
        super(itemView);
        txtContent = itemView.findViewById(R.id.txtContent);
        txtAuthor = itemView.findViewById(R.id.txtAuthor);
    }
}
