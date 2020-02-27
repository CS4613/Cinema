package org.snowcorp.app.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.snowcorp.app.R;
import org.snowcorp.app.adapter.ReviewAdapter;
import org.snowcorp.app.fragment.RateFragment;
import org.snowcorp.app.fragment.ReviewFragment;
import org.snowcorp.app.model.MovieDetails;
import org.snowcorp.app.model.ReviewResult;
import org.snowcorp.app.presenter.MovieDetailPresenter;
import org.snowcorp.app.utils.HideKeyboard;
import org.snowcorp.app.view.MovieDetialView;

import java.util.ArrayList;
import java.util.List;

public class DetailActivity extends AppCompatActivity implements MovieDetialView {
    TextView txtTitle, txtGenre, txtRating, txtReleaseDate, txtOverview, txtProduceBy;
    ImageView imgMovie;
    String title;
    int id;
    MovieDetailPresenter presenter;
    ProgressDialog progressDialog;
    FloatingActionButton reviewFab, bookingFab;
    ReviewAdapter adapter;
    RatingBar ratingBar;
    RecyclerView recyclerView;
    LinearLayout lytReview;
    LinearLayout lytRating;
    List<ReviewResult> list = new ArrayList();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        title = getIntent().getStringExtra("title");
        id = getIntent().getIntExtra("id", 0);
        presenter = new MovieDetailPresenter(this, DetailActivity.this);
        new HideKeyboard(this).setupUI(findViewById(android.R.id.content));
        initToolbar();
        findViews();
        eventHandling();
        Log.d("ID", String.valueOf(id));
        presenter.getMovieID(id);

    }


    private void eventHandling() {
        reviewFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ReviewFragment reviewFragment = new ReviewFragment();
                Bundle bundle = new Bundle();
                bundle.putInt("Id", id);
                reviewFragment.setArguments(bundle);
                reviewFragment.show(getFragmentManager().beginTransaction(), null);
            }
        });
        bookingFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RateFragment reviewFragment = new RateFragment();
                Bundle bundle = new Bundle();
                bundle.putInt("Id", id);
                reviewFragment.setArguments(bundle);
                reviewFragment.show(getFragmentManager().beginTransaction(), null);
            }
        });
    }

    private void findViews() {
        txtTitle = findViewById(R.id.txtTitle);
        txtGenre = findViewById(R.id.txtGenre);
        txtRating = findViewById(R.id.txtRating);
        txtReleaseDate = findViewById(R.id.txtReleaseDate);
        ratingBar = findViewById(R.id.ratingBar);
        txtOverview = findViewById(R.id.txtOverview);
        txtProduceBy = findViewById(R.id.txtProduceBy);
        imgMovie = findViewById(R.id.imgMovie);
        lytReview = findViewById(R.id.lytReview);
        lytRating = findViewById(R.id.lytRating);
        recyclerView = findViewById(R.id.recycleView);
        reviewFab = findViewById(R.id.reviewFab);
        bookingFab = findViewById(R.id.bookingFab);
        progressDialog = new ProgressDialog(DetailActivity.this, R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Loading...");
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setNestedScrollingEnabled(false);

    }

    private void initToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.getReview(id);

    }

    @Override
    public void onLoading() {
        progressDialog.show();
    }

    @Override
    public void onSuccess(String message) {
        progressDialog.dismiss();
        Toast.makeText(getBaseContext(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void setAdapter(List<ReviewResult> reviewList) {
        progressDialog.dismiss();

        if (reviewList.size() > 0) {
            lytReview.setVisibility(View.VISIBLE);
            if (list == null)
                list = reviewList;
            else {
                list.clear();
                list.addAll(reviewList);
            }
            adapter = new ReviewAdapter(list);
            recyclerView.setAdapter(adapter);
        } else {
            lytReview.setVisibility(View.GONE);
        }
    }


    @Override
    public void setMovie(MovieDetails movie) {
        progressDialog.dismiss();
        lytRating.setVisibility(View.VISIBLE);
        String genre = "";
        String produceBy = "";
        for (int i = 0; i < movie.getGenres().size(); i++) {
            genre += movie.getGenres().get(i).getName() + ", ";
        }
        for (int i = 0; i < movie.getProductionCompanies().size(); i++) {
            produceBy += movie.getProductionCompanies().get(i).getName() + ", ";
        }

        ratingBar.setRating(Float.valueOf(String.valueOf(movie.getVoteAverage())));
        txtTitle.setText(movie.getTitle());
        txtGenre.setText("Genre: " + genre);
        txtRating.setText("Popularity: " + movie.getPopularity().toString());
        txtOverview.setText("Overview: " + movie.getOverview());
        txtReleaseDate.setText(movie.getReleaseDate());
        txtProduceBy.setText("Produce By: " + produceBy);
        Picasso.with(this).load("https://image.tmdb.org/t/p/w500/" + movie.getPosterPath()).transform(new ImageTrans_roundedcorner()).into(imgMovie);

    }

    @Override
    public void onFailed(String message) {
        progressDialog.dismiss();
        Toast.makeText(getBaseContext(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);

    }
}
