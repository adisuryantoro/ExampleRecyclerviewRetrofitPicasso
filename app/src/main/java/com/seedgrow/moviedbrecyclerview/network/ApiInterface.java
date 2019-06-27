package com.seedgrow.moviedbrecyclerview.network;

import com.seedgrow.moviedbrecyclerview.model.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("movie/top_rated")
    Call<MovieResponse> getTopRatedMovies(@Query("api_key") String apiKey);

    @GET("movie/upcoming")
    Call<MovieResponse> getMovieUpcoming(@Query("api_key") String api_key);

}
