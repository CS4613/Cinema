package org.snowcorp.app.fragment;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.snowcorp.app.Interface.OnClickListerner;
import org.snowcorp.app.R;
import org.snowcorp.app.activity.BookingActivity;
import org.snowcorp.app.activity.DetailActivity;
import org.snowcorp.app.adapter.MovieAdapter;
import org.snowcorp.app.adapter.MovieBookingAdapter;
import org.snowcorp.app.model.BookingMovieResult;
import org.snowcorp.app.model.MovieResult;
import org.snowcorp.app.presenter.MoviePresenter;
import org.snowcorp.app.utils.GlobalUtils;
import org.snowcorp.app.view.MovieVIew;

import java.util.ArrayList;
import java.util.List;

import dmax.dialog.SpotsDialog;


public class MovieBookingFragment extends Fragment implements MovieVIew {


    AlertDialog dialog;

    private String mParam1;
    private String mParam2;
    RecyclerView recyclerView;
    MoviePresenter presenter;
    FloatingActionButton fabBooking;
    MovieBookingAdapter adapter;
    List<BookingMovieResult> movieList = new ArrayList<>();
    int currentPage = 1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movie_boking, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        fabBooking = (FloatingActionButton) view.findViewById(R.id.fabBooking);
        dialog = new SpotsDialog(getActivity(), R.style.Custom);
        adapter = new MovieBookingAdapter(getContext(), movieList);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        presenter = new MoviePresenter(this, getContext());
        presenter.getBookedMovie();
        fabBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GlobalUtils.navigateActivity(getContext(), false, BookingActivity.class);
            }
        });
        return view;
    }


    @Override
    public void onLoading() {

    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.getBookedMovie();
    }

    @Override
    public void onDataSuccess(List<MovieResult> movieList) {

    }

    @Override
    public void onSuccess(List<BookingMovieResult> movieList) {
        this.movieList.clear();
        this.movieList.addAll(movieList);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onFailed() {

    }
}
