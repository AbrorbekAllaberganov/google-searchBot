package news;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import imageJson.ImageResponse;
import newsJson.NewsResponse;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.lang.reflect.Type;

public class NewsService {


    public NewsResponse getNews(String text){
        Gson gson=new Gson();
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://google-search3.p.rapidapi.com/api/v1/news/q="+text)
                .get()
                .addHeader("x-rapidapi-host", "google-search3.p.rapidapi.com")
                .addHeader("x-rapidapi-key", "b8aa608876mshb8a6efa7542cd60p1bbb41jsn03c0ccd23533")
                .build();

        try {
            Response response = client.newCall(request).execute();

            String jsonData=response.body().string();

//            System.out.println(jsonData);

            Type type = new TypeToken<NewsResponse>() {
            }.getType();

            NewsResponse result = gson.fromJson(jsonData, type);

            System.out.println(result.getEntries().get(0).getTitle());
            return result;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
