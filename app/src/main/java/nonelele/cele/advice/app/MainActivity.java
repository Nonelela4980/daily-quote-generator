package nonelele.cele.advice.app;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;
import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView textQuote,textDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textQuote = findViewById(R.id.tvAdvice);
        textDate = findViewById(R.id.tvDay);

        Date date = new Date();

        textDate.setText(date.toLocaleString());

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://zenquotes.io/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
        Call<List<Quote>> call = jsonPlaceHolderApi.getQuotes();
        call.enqueue(new Callback<List<Quote>>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(Call<List<Quote>> call, Response<List<Quote>> response) {
                if(!response.isSuccessful()){
                    textQuote.setText("Code: "+response.code());
                    return;
                }
                List<Quote> list = response.body();
               if(list!=null)
               {
                   Quote quote = list.get(0);
                   textQuote.setText("'"+quote.getQ()+"' - "+quote.getA());
               }
            }

            @Override
            public void onFailure(Call<List<Quote>> call, Throwable t) {
                runOnUiThread(()->{
                    textQuote.setText(t.getMessage());
                    Toast.makeText(getApplicationContext(),"Request Failed",Toast.LENGTH_LONG).show();
                });
            }
        });
    }
}