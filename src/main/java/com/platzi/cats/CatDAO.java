package com.platzi.cats;

import com.google.gson.Gson;
import okhttp3.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class CatDAO {
    public static Icon getCat() throws IOException {
        //1. vamos a traer los datos de la API
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder().url("https://api.thecatapi.com/v1/images/search").method("GET", null).build();

        Response response = client.newCall(request).execute();

        String json = response.body().string();
        json = json.substring(1, json.length());
        json = json.substring(0, json.length() - 1);

        //crear u objeto de la clase Gson
        Gson gson = new Gson();
        Cat cats = gson.fromJson(json, Cat.class);

        Image image = null;
        ImageIcon bgCat = null;
        try {
            URL url = new URL(cats.getUrl());
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            http.addRequestProperty("User-Agent", "");
            BufferedImage bufferedImage = ImageIO.read(http.getInputStream());
            bgCat = new ImageIcon(bufferedImage);


            if (bgCat.getIconWidth() > 800) {
                //redimensionamos
                Image bg = bgCat.getImage();
                Image modificada = bg.getScaledInstance(800, 600, java.awt.Image.SCALE_SMOOTH);
                bgCat = new ImageIcon(modificada);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return bgCat;
    }
    public static void addCatToFavorite(Cat cat){
        try{
            OkHttpClient client = new OkHttpClient();
            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, "{\n\t\"image_id\":\""+cat.getId()+"\"\n}");
            Request request = new Request.Builder()
                    .url("https://api.thecatapi.com/v1/favourites")
                    .post(body)
                    .addHeader("Content-Type", "application/json")
                    .addHeader("x-api-key", cat.getApiKey())
                    .build();
            Response response = client.newCall(request).execute();

        }catch(IOException e){
            System.out.println(e);
        }
    }
}
