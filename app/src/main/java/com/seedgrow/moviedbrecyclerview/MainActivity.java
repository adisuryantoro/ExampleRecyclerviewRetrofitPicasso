package com.seedgrow.moviedbrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.seedgrow.moviedbrecyclerview.model.Movie;
import com.seedgrow.moviedbrecyclerview.model.MovieResponse;
import com.seedgrow.moviedbrecyclerview.network.APIMovieClient;
import com.seedgrow.moviedbrecyclerview.network.APIMovieInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    // TODO - insert your themoviedb.org API KEY here
    private final static String API_KEY = "ec067956bcd6ac32f62ff0a1a4828dfb";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (API_KEY.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please obtain your API KEY first from themoviedb.org", Toast.LENGTH_LONG).show();
            return;
        }

        APIMovieInterface apiService =
                APIMovieClient.getClient().create(APIMovieInterface.class);

        Call<MovieResponse> call = apiService.getTopRatedMovies(API_KEY);
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse>call, Response<MovieResponse> response) {
                List<Movie> movies = response.body().getResults();
                Log.d(TAG, "Number of movies received: " + movies.size());
                Toast.makeText(MainActivity.this, "Number of movies received: " + movies.size(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<MovieResponse>call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
            }
        });
    }
}
