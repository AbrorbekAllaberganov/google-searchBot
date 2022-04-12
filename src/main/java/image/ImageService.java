package image;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import imageJson.ImageResponse;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.lang.reflect.Type;

public class ImageService {

    public ImageResponse getImages(String theme) {
        Gson gson = new Gson();
        OkHttpClient client = new OkHttpClient();

        //REQUES


        try {
            Response response = client.newCall(request).execute();

            String jsonData = response.body().string();
            System.out.println(jsonData);

            Type type = new TypeToken<ImageResponse>() {
            }.getType();

            ImageResponse result = gson.fromJson(jsonData, type);

            return result;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
