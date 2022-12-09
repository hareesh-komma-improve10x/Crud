package com.improve10x.crud.api;

import com.improve10x.crud.Constants;
import com.improve10x.crud.messages.Message;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface CrudService {
    @GET(Constants.MESSAGE_END_POINT)
    Call<List<Message>> fetchMessages();

    @POST(Constants.MESSAGE_END_POINT)
    Call<Message> createMessage(@Body Message messages);

    @DELETE(Constants.MESSAGE_END_POINT + "/{id}")
    Call<Void> deleteMessage(@Path("id") String id);
}
