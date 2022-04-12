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

       //REQUEST

        try {
            Response response = client.newCall(request).execute();

            String jsonData=response.body().string();


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
