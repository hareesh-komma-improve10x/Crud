package com.improve10x.crud.series;

import com.improve10x.crud.Constants;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface SeriesItemsService {
    @GET(Constants.SERIES_END_POINT)
    Call<List<SeriesItem>> fetchSeriesItems();

    @POST(Constants.SERIES_END_POINT)
    Call<SeriesItem> createSeriesItem(@Body SeriesItem seriesItem);

    @DELETE(Constants.SERIES_END_POINT + "/{id}")
    Call<Void> deleteSeriesItem(@Path("id")String id);


}
