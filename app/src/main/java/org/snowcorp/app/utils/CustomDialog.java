package org.snowcorp.app.utils;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import org.snowcorp.app.Interface.OnClickListerner;
import org.snowcorp.app.R;
import org.snowcorp.app.adapter.MovieAdapter;
import org.snowcorp.app.model.BookingMovieResult;
import org.snowcorp.app.model.Movie;
import org.snowcorp.app.model.MovieResult;
import org.snowcorp.app.view.DialogListner;
import org.snowcorp.app.view.MovieDialogListner;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;



public class CustomDialog {
    public static String phoneNumber;
    public static List<MovieResult> movieList = new ArrayList<>();
    public static MovieAdapter adapter;

    public static void showLogOutDialog(final Context context, final DialogListner dialogListner) {
        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        final View view = View.inflate(context, R.layout.logout_custom_dialog, null);
        alertDialogBuilder.setView(view);
        final Dialog originalDialog = alertDialogBuilder.create();
        originalDialog.getWindow().setDimAmount(0.7f);
        Button btnok = (Button) view.findViewById(R.id.btnOk);
        Button btnCancel = (Button) view.findViewById(R.id.btnCancel);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                originalDialog.dismiss();

            }
        });

        btnok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogListner.onOkClicked();
                originalDialog.dismiss();

            }
        });

        originalDialog.setCancelable(false);
        originalDialog.show();
    }

    public static void showMovieList(final Context context, final MovieDialogListner dialogListner, final String dateTime) {
        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        final View view = View.inflate(context, R.layout.movie_list_custom_dialog, null);
        alertDialogBuilder.setView(view);
        final Dialog originalDialog = alertDialogBuilder.create();
        originalDialog.getWindow().setDimAmount(0.7f);
        Button btnok = (Button) view.findViewById(R.id.btnOk);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        Button btnCancel = (Button) view.findViewById(R.id.btnCancel);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        final BookingMovieResult movieResult = new BookingMovieResult();
        getMovieList();
        adapter = new MovieAdapter(context, movieList, new OnClickListerner() {
            @Override
            public void onClick(int position) {
                movieResult.setDateTime(dateTime);
                movieResult.setId(movieList.get(position).getId());
                movieResult.setTitle(movieList.get(position).getTitle());
            }
        });
        recyclerView.setAdapter(adapter);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                originalDialog.dismiss();

            }
        });

        btnok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogListner.onOkClicked(movieResult);
                originalDialog.dismiss();

            }
        });
        originalDialog.setCancelable(false);
        originalDialog.show();
    }

    public static void getMovieList() {
        movieList.clear();
        Realm realm = Realm.getDefaultInstance();
        Movie results = realm.copyFromRealm(realm.where(Movie.class).findFirst());
        movieList.addAll(results.getResults());
    }


}
