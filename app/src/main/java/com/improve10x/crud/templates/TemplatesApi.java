package com.improve10x.crud.templates;

import com.improve10x.crud.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TemplatesApi {
     TemplatesService createTemplatesService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        TemplatesService templatesService = retrofit.create(TemplatesService.class);
        return templatesService;
    }
}
