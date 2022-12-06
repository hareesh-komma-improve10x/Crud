package messages;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface MessagesService {
    @GET("hareeshMessageHistory")
    Call<List<Message>> fetchMessages();

    @POST("hareeshMessageHistory")
    Call<Message> createMessage(@Body Message messages);

    @DELETE("hareeshMessageHistory/{id}")
    Call<Void> deleteMessage(@Path("id") String id);
}
