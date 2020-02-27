package org.snowcorp.app.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import org.snowcorp.app.R;
import org.snowcorp.app.activity.ImageTrans_roundedcorner;
import org.snowcorp.app.model.ReviewResult;

import java.util.List;


public class ReviewAdapter extends RecyclerView.Adapter<ReviewVH> {

    private List<ReviewResult> list;


    public ReviewAdapter(List<ReviewResult> list) {
        this.list = list;

    }

    @Override
    public ReviewVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;

        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_review, parent, false);
        return new ReviewItemVH(view);
    }

    @Override
    public void onBindViewHolder(final ReviewVH holder, int position) {
        ((ReviewItemVH) holder).txtContent.setText(list.get(position).getContent());
        ((ReviewItemVH) holder).txtAuthor.setText(list.get(position).getAuthor());

     }

    @Override
    public int getItemCount() {
        return list.size();
    }


}
