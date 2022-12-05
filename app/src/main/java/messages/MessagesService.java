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
    Call<List<Messages>> fetchTasks();

    @POST("hareeshMessageHistory")
    Call<Messages> createTasks (@Body Messages messages);

    @DELETE("hareeshMessageHistory/{id}")
    Call<Void> deleteMessage (@Path("id") String id);
}
