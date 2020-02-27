package org.snowcorp.app.fragment;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.snowcorp.app.Interface.OnClickListerner;
import org.snowcorp.app.R;
import org.snowcorp.app.activity.DetailActivity;
import org.snowcorp.app.adapter.MovieAdapter;
import org.snowcorp.app.model.BookingMovieResult;
import org.snowcorp.app.model.MovieResult;
import org.snowcorp.app.presenter.MoviePresenter;
import org.snowcorp.app.view.MovieVIew;

import java.util.ArrayList;
import java.util.List;

import dmax.dialog.SpotsDialog;


public class MovieFragment extends Fragment implements MovieVIew {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    AlertDialog dialog;

    private String mParam1;
    private String mParam2;
    RecyclerView recyclerView;
    MoviePresenter presenter;
    MovieAdapter adapter;
    List<MovieResult> movieList = new ArrayList<>();
    int currentPage = 1;

    public static MovieFragment newInstance(String param1, String param2) {
        MovieFragment fragment = new MovieFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_github, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.github_recylerView);
        dialog = new SpotsDialog(getActivity(), R.style.Custom);
        adapter = new MovieAdapter(getContext(), movieList, new OnClickListerner() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(getContext(), DetailActivity.class);
                intent.putExtra("id", movieList.get(position).getId());
                intent.putExtra("title", movieList.get(position).getTitle());
                startActivity(intent);
            }
        });
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        presenter = new MoviePresenter(this, getContext());
        presenter.interactorCall(currentPage);

        return view;
    }


    @Override
    public void onLoading() {

    }

    @Override
    public void onDataSuccess(List<MovieResult> movieList) {
        this.movieList.clear();
        this.movieList.addAll(movieList);
        adapter.notifyDataSetChanged();

    }

    @Override
    public void onSuccess(List<BookingMovieResult> movieList) {

    }

    @Override
    public void onFailed() {

    }
}
