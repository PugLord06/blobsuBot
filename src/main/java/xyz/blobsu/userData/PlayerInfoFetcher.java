package xyz.blobsu.userData;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class PlayerInfoFetcher {

    private static final String API_URL = "https://api.blobsu.xyz/v1/get_player_info?scope=all&name=";
    private static final OkHttpClient client = new OkHttpClient();
    private static final Gson gson = new Gson();

    public static PlayerInfoResponse fetchPlayerInfo(String userName) {
        String url = API_URL + userName;

        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {

            String jsonData = null;
            //Change this when linking discord
            if (response.body() != null) {
                jsonData = response.body().string();
            }
            return gson.fromJson(jsonData, PlayerInfoResponse.class);
        } catch (IOException e) {
            e.printStackTrace();

            return null;
        }
    }
}



