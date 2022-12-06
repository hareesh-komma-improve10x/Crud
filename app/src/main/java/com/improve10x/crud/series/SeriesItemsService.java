package com.improve10x.crud.series;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface SeriesItemsService {
    @GET("hareeshSeries")
    Call<List<SeriesItem>> fetchSeriesItems();

    @POST("hareeshSeries")
    Call<SeriesItem> createSeriesItem(@Body SeriesItem seriesItem);

    @DELETE("hareeshSeries/{id}")
    Call<Void> deleteSeriesItem(@Path("id")String id);


}
