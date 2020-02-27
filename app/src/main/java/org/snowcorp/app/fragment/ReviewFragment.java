package org.snowcorp.app.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import org.snowcorp.app.R;
import org.snowcorp.app.model.MovieDetails;
import org.snowcorp.app.model.ReviewResult;
import org.snowcorp.app.presenter.MovieDetailPresenter;
import org.snowcorp.app.utils.GlobalUtils;
import org.snowcorp.app.view.MovieDetialView;

import java.util.List;

import static android.content.Context.INPUT_METHOD_SERVICE;


public class ReviewFragment extends DialogFragment implements MovieDetialView {

    MovieDetailPresenter presenter;
    AlertDialog.Builder alertDialog;
    View view;
    EditText edtReview, edtAuthor;
    Button btnSubmit;
    ImageView imgCross;
    ProgressDialog progressDialog;
    int movieID;


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        view = View.inflate(getActivity(), R.layout.fragment_review, null);
        alertDialog = new AlertDialog.Builder(getActivity());
        alertDialog.setView(view);
        AlertDialog originalDialog = alertDialog.create();
        originalDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        originalDialog.getWindow().setDimAmount(0.7f);
        presenter = new MovieDetailPresenter(this, getActivity());
        findView();
        eventHandling();
        return originalDialog;
    }

    private void findView() {
        edtReview = view.findViewById(R.id.edtReview);
        edtAuthor = view.findViewById(R.id.edtAuthor);
        btnSubmit = view.findViewById(R.id.btnSubmit);
        imgCross = view.findViewById(R.id.imgCross);
        progressDialog = new ProgressDialog(getActivity(), R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Loading...");
        edtAuthor.setText(GlobalUtils.getFromPref("name", getActivity()));
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        movieID = getArguments().getInt("Id");
        Log.d("MovieId", String.valueOf(movieID));
    }

    private void eventHandling() {
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String review = edtReview.getText().toString().trim();
                String author = edtAuthor.getText().toString().trim();
                if (!TextUtils.isEmpty(review)) {
                    presenter.saveReview(review, author, movieID);
                } else {
                    edtReview.setError("ReviewResult cannot be empty");
                }
            }
        });
        imgCross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(edtReview.getWindowToken(), 0);
                dismiss();
            }
        });
    }


    @Override
    public void onLoading() {
        progressDialog.show();
    }

    @Override
    public void onSuccess(String message) {
        progressDialog.dismiss();
        edtReview.setText("");
        Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void setAdapter(List<ReviewResult> reviewList) {

    }

    @Override
    public void setMovie(MovieDetails movie) {

    }

    @Override
    public void onFailed(String message) {
        progressDialog.dismiss();
        Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
    }
}
