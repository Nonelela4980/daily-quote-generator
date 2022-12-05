package nonelele.cele.advice.app;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {

    @GET("quotes")
    Call<List<Quote>>  getQuotes();
}
