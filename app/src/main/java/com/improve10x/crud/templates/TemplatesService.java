package com.improve10x.crud.templates;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface TemplatesService {
    @GET("hareeshTemplates")
    Call<List<Templates>> fetchData();

    @POST("hareeshTemplates")
    Call<Templates> createData(@Body Templates templates);

    @DELETE("hareeshTemplates/{id}")
    Call<Void> deleteTemplates (@Path("id") String id);

}