package com.improve10x.crud.series;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SeriesItemsApi {
    public SeriesItemsService createSeriesItemsService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://crudcrud.com/api/479dd07f8c1d482e9219f7dcb48e25f4/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        SeriesItemsService seriesItemsService = retrofit.create(SeriesItemsService.class);
        return seriesItemsService;
    }
}
