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
    Call<List<Template>> fetchTemplates();

    @POST("hareeshTemplates")
    Call<Template> createTemplate(@Body Template templates);

    @DELETE("hareeshTemplates/{id}")
    Call<Void> deleteTemplate(@Path("id") String id);

}
