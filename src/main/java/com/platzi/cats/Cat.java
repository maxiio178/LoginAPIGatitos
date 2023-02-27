package com.platzi.cats;

public class Cat {
    private String id;
    private String url;
    private String apiKey = "live_OxGmYZyeAkBTZuKp6ZiUuNMa5EvZJcI4zSrX7u6tZh0BRQGd7BTrxyYXQr7Mpj1t";
    private String img;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public  String getUrl() {
        return url;
    }

    public  void setUrl(String url) {
        this.url = url;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
