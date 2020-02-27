package org.snowcorp.app.activity;

import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import org.snowcorp.app.Interface.OnClickListerner;
import org.snowcorp.app.R;
import org.snowcorp.app.adapter.MovieAdapter;
import org.snowcorp.app.model.MovieResult;
import org.snowcorp.app.presenter.MoviePresenter;
import org.snowcorp.app.presenter.SearchPresenter;
import org.snowcorp.app.utils.GlobalUtils;
import org.snowcorp.app.view.SearchActivityView;

import android.support.v7.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity implements SearchActivityView, SearchView.OnQueryTextListener {

    MovieAdapter adapter;
    ProgressDialog progressDialog;
    SearchPresenter presenter;
    RecyclerView recyclerView;
    SearchView searchView;
    MenuItem searchItem;
    List<MovieResult> movieList = new ArrayList<>();
    int currentPage = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        initToolbar();
        findViews();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_activity_menu, menu);
        try {
            SearchManager searchManager = (SearchManager) getSystemService(SearchActivity.SEARCH_SERVICE);
            searchItem = menu.findItem(R.id.action_search);
            searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
            searchView.setOnQueryTextListener(this);
            searchView.setOnCloseListener(new SearchView.OnCloseListener() {
                @Override
                public boolean onClose() {
                    onBackPressed();
                    return false;
                }
            });
        } catch (Exception ex) {

        }
        return true;
    }

    @Override
    public void onLoading() {
        progressDialog.show();
    }

    @Override
    public void setAdapter(final List<MovieResult> movieList) {
        progressDialog.dismiss();
        if (this.movieList == null)
            this.movieList = movieList;
        else {
            this.movieList.clear();
            this.movieList.addAll(movieList);
        }
        adapter = new MovieAdapter(this, movieList, new OnClickListerner() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(SearchActivity.this, DetailActivity.class);
                intent.putExtra("id", movieList.get(position).getId());
                intent.putExtra("title", movieList.get(position).getTitle());
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        searchView.setIconifiedByDefault(true);
        searchView.setFocusable(true);
        searchView.setIconified(false);
        searchView.requestFocusFromTouch();
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public void onFailed() {
        progressDialog.dismiss();

    }

    private void initToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
    }

    private void findViews() {
        presenter = new SearchPresenter(this, this);
        progressDialog = new ProgressDialog(this, R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Loading...");
        recyclerView = findViewById(R.id.recycleView);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        presenter.searchItem("");
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        presenter.searchItem(newText);

        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        Log.d("MenuID", String.valueOf(id));

        if (id == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
