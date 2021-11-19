package wikipediya;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import imageJson.ImageResponse;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import wikiJson.WikiResponse;

import java.io.IOException;
import java.lang.reflect.Type;

public class WikipediyaService {


    public  WikiResponse getWikipediya(String text){
        Gson gson=new Gson();
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://google-search3.p.rapidapi.com/api/v1/crawl/q=Messi")
                .get()
                .addHeader("x-rapidapi-host", "google-search3.p.rapidapi.com")
                .addHeader("x-rapidapi-key", "b8aa608876mshb8a6efa7542cd60p1bbb41jsn03c0ccd23533")
                .build();

        try {
            Response response = client.newCall(request).execute();
            String jsonData=response.body().string();
            Type type = new TypeToken<WikiResponse>() {
            }.getType();

            WikiResponse result = gson.fromJson(jsonData, type);

            return result;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
