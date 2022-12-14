package com.improve10x.crud.api;

import com.improve10x.crud.messages.Message;
import com.improve10x.crud.series.SeriesItem;
import com.improve10x.crud.templates.Template;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface CrudService {
    @GET(Constants.MESSAGE_END_POINT)
    Call<List<Message>> fetchMessages();

    @POST(Constants.MESSAGE_END_POINT)
    Call<Message> createMessage(@Body Message messages);

    @DELETE(Constants.MESSAGE_END_POINT + "/{id}")
    Call<Void> deleteMessage(@Path("id") String id);

    @PUT(Constants.MESSAGE_END_POINT + "/{id}")
    Call<Void> updatedMessage (@Path("id") String id, @Body Message message);

    @GET(Constants.TEMPLATE_END_POINT)
    Call<List<Template>> fetchTemplates();

    @POST(Constants.TEMPLATE_END_POINT)
    Call<Template> createTemplate(@Body Template templates);

    @DELETE(Constants.TEMPLATE_END_POINT + "/{id}")
    Call<Void> deleteTemplate(@Path("id") String id);

    @PUT(Constants.TEMPLATE_END_POINT + "/{id}")
    Call<Void> updatedTemplate(@Path("id") String id, @Body Template template);

    @GET(Constants.SERIES_END_POINT)
    Call<List<SeriesItem>> fetchSeriesItems();

    @POST(Constants.SERIES_END_POINT)
    Call<SeriesItem> createSeriesItem(@Body SeriesItem seriesItem);

    @DELETE(Constants.SERIES_END_POINT + "/{id}")
    Call<Void> deleteSeriesItem(@Path("id")String id);
}
